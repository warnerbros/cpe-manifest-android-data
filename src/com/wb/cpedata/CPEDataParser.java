package com.wb.cpedata;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.SystemClock;

import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.security.ProviderInstaller;
import com.wb.cpedata.data.manifest.MovieMetaData;
import com.wb.cpedata.network.BaselineApiDAO;
import com.wb.cpedata.network.NGECacheManager;
import com.wb.cpedata.network.TheTakeApiDAO;
import com.wb.cpedata.parser.ManifestXMLParser;
import com.wb.cpedata.util.utils.CPEDataParserLogger;
import com.wb.cpedata.util.utils.F;
import com.wb.cpedata.util.utils.StringHelper;

import java.util.List;
import java.util.Locale;

/**
 * Created by gzcheng on 8/10/16.
 */
public class CPEDataParser {

    public static int sCachePolicy = NGECacheManager.POLICY_MEDIUM;
    public static NGECacheManager sCacheManager;
    private static Locale clientLocale = null;
    private static ManifestItem manifestItem = null;
    private static String studioXAPIKey = null;
    private static Context applicationContext = null;
    private static MovieMetaData movieMetaData = null;

	private static String sUserAgent;

    public static String getStudioXAPIKey(){
        return studioXAPIKey;
    }

    public static MovieMetaData parseCPEManifests(Context applicationContext, ManifestItem manifestItem, Locale locale) {
		try{
			CPEDataParser.applicationContext = applicationContext;
			sCacheManager = new NGECacheManager(applicationContext);
			sUserAgent = "Android/" + Build.VERSION.CODENAME + " (Linux; U; Android " + Build.VERSION.RELEASE + "; " + Build.MODEL + ")";
			CPEDataParserLogger.d("TIME_THIS", "---------------Next Test--------------");

			long systime = SystemClock.uptimeMillis();
			ManifestXMLParser.NextGenManifestData manifest = new ManifestXMLParser().startParsing(manifestItem.getManifestFileUrl(),
					manifestItem.getAppDataFileUrl(), manifestItem.getNgeStyleFileUrl(), locale);
			long currentTime = SystemClock.uptimeMillis() - systime;
			CPEDataParserLogger.d("TIME_THIS", "Time to finish parsing: " + currentTime);

			// TODO error handling if manifest is null
			movieMetaData = MovieMetaData.process(manifest);


			currentTime = SystemClock.uptimeMillis() - currentTime - systime;
			CPEDataParserLogger.d("TIME_THIS", "Time to finish processing: " + currentTime);

			BaselineApiDAO.init();
            BaselineApiDAO.getCastActorsImages(movieMetaData.getAllCastsList(), null);

			TheTakeApiDAO.init();
			return movieMetaData;
		}catch (Exception ex){
			CPEDataParserLogger.e(F.TAG, ex.getLocalizedMessage());
			CPEDataParserLogger.e(F.TAG, ex.getStackTrace().toString());
			return null;
		}
    }

    public static MovieMetaData getMovieMetaData(){
    	return movieMetaData;
	}

    public static Context getApplicationContext(){
    	return applicationContext;
	}

    public static ManifestItem getManifestItem(){
        return manifestItem;
    }

    public static int getCachePolicy() {
        return sCachePolicy;
    }

    public static String getUserAgent() {
        return sUserAgent;
    }

    public static Locale getClientLocale(){
        return clientLocale;
    }

    public static boolean isDebugBuild() {
        return true;
    }

    public static boolean matchesClientLocale(String languageLocale){
        if (languageLocale != null){
            languageLocale = languageLocale.replace("-", "_");
            if (languageLocale.contains("_")){  // this is locale
                return clientLocale.toString().equals(languageLocale);
            }else{      // this is language
                return clientLocale.getLanguage().equals(languageLocale);
            }
        }
        return false;
    }
}
