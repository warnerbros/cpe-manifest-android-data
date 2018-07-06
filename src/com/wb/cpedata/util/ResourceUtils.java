package com.wb.cpedata.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


import com.wb.cpedata.util.utils.CPEDataParserLogger;
import com.wb.cpedata.util.utils.F;

import android.content.Context;
import android.content.res.AssetManager;


final public class ResourceUtils {
	
	private ResourceUtils() {
	};
	
	public static String getStringFromAssets(Context context, String fileName) {
		AssetManager am = context.getAssets();
		StringBuilder sb = new StringBuilder();
		InputStream in = null;
		try {
			in = am.open(fileName);
			InputStreamReader is = new InputStreamReader(in);
			BufferedReader br = new BufferedReader(is);
			String read = br.readLine();
			
			while (read != null) {
				sb.append(read);
				read = br.readLine();
			}
		} catch (IOException e) {
			CPEDataParserLogger.e(F.TAG, "ResourceUtils.getStringFromAssets: " + e.getMessage(), e);
		} finally {
			try {
				if (in != null)
					in.close();
			} catch (IOException e) {
				CPEDataParserLogger.e(F.TAG, "ResourceUtils.getStringFromAssets: " + e.getMessage(), e);
			}
		}
		return sb.toString();
		
	}
}
