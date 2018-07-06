package com.wb.cpedata.util.utils;

import java.io.File;
import java.io.FileFilter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.util.regex.Pattern;

//import com.crashlytics.android.Crashlytics;
import com.wb.cpedata.CPEDataParser;

import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import android.util.Log;

/**
 * A wrapper around android.util.Log with support for sensitive logging and logging toggle
 */
public class CPEDataParserLogger {

	static final String LOGGER_NAME = "com.flixster.FlixsterVideoLogger";
	static final int MAX_NUMBER_OF_LOG_FILES = 7;
	private static Logger logger = null;
	private static FileHandler fh = null;
	private static String currentLogFilename = null;
	
	private static String getTodaysLogFileName(){
		SimpleDateFormat dateFormat = new SimpleDateFormat("-yyyy-MM-dd");
		Date date = new Date();
		return F.LOGGER_FILE_DIR + F.LOGGER_FILE_NAME + dateFormat.format(date) + F.LOGGER_FILE_EXT;
	}
	
	private static File[] getExistingLogFiles(){
		File f = new File(Environment.getExternalStorageDirectory() + F.LOGGER_FILE_DIR);
		final Pattern p = Pattern.compile(F.LOGGER_FILE_NAME + ".*" + F.LOGGER_FILE_EXT); 	// search for files matching the pattern of "flixsterUserLog.*.txt";
	    File[] flists = f.listFiles(new FileFilter() {
			

	        @Override
	        public boolean accept(File file) {
	            return p.matcher(file.getName()).matches();
	        }
	    });
	    
	    return flists;
	}
	
	private static File[] getLCKFiles(){
		File f = new File(Environment.getExternalStorageDirectory() + F.LOGGER_FILE_DIR);
		final Pattern p = Pattern.compile(F.LOGGER_FILE_NAME + ".*" + F.LOGGER_FILE_EXT +".lck"); 	// search for files matching the pattern of "flixsterUserLog.*.txt";
	    File[] flists = f.listFiles(new FileFilter() {
			

	        @Override
	        public boolean accept(File file) {
	            return p.matcher(file.getName()).matches();
	        }
	    });
	    
	    return flists;
	}
	
	private static void init(){
		if (logger == null){		// initialize logger object
			logger = Logger.getLogger(LOGGER_NAME);
			logger.setLevel(Level.CONFIG);
			logger.setUseParentHandlers(false);		// do not output to console
		}
		
		if (StringHelper.isEmpty(currentLogFilename) || !getTodaysLogFileName().equals(currentLogFilename) ){	// this is when we need to create new file
			if (fh != null)						// if file handler exist, remove it as we need to create a new log file with today's date.
				logger.removeHandler(fh);
			
			File dir = new File(Environment.getExternalStorageDirectory(), F.LOGGER_FILE_DIR);
		    if (!dir.exists()) {				// if the directory does not exist, create one.
		    	dir.mkdirs();
		    } else {							// directory exists, check and clear up old log files
		    	File[] logFiles = getExistingLogFiles();
		    	if (logFiles != null && logFiles.length > MAX_NUMBER_OF_LOG_FILES){	// clean up only when there are more than 7 log files
		    		Arrays.sort(logFiles);
		    		for (int i = 0; i < logFiles.length - MAX_NUMBER_OF_LOG_FILES; i++){
		    			logFiles[i].delete();
		    		}
		    	}
		    	File[] lckFiles = getLCKFiles();
		    	if (lckFiles != null && lckFiles.length > 0){
		    		for (int i = 0; i < lckFiles.length; i++){
		    			lckFiles[i].delete();
		    		}
		    	}
		    }
		    
			try {
				currentLogFilename = getTodaysLogFileName();
				fh = new FileHandler(Environment.getExternalStorageDirectory() + currentLogFilename, false);
			} catch (Exception e) {
				 e.printStackTrace();
			}
			if (fh != null){
				fh.setFormatter(new SimpleFormatter());
				logger.addHandler(fh);
			}
		}
		
	}
	
	private static Logger getLogger() {
		init();
		return logger;
	}
	
	/** A sensitive verbose msg is only logged on dev builds or in diagnostic mode */
	@SuppressWarnings("unused")
	public static void sv(String tag, String msg) {
		if (CPEDataParser.isDebugBuild())
			Log.v(tag, msg);
		
		getLogger().log(Level.INFO, tag + "\t" + msg);
	}
	
	/** A sensitive debug msg is only logged on dev builds or in diagnostic mode */
	@SuppressWarnings("unused")
	public static void sd(String tag, String msg) {
		if (CPEDataParser.isDebugBuild())
			Log.d(tag, msg);
	}
	
	/** A sensitive info msg is only logged on dev builds or in diagnostic mode */
	@SuppressWarnings("unused")
	public static void si(String tag, String msg) {
		if (CPEDataParser.isDebugBuild())
			Log.i(tag, msg);
	}
	
	/** Forced logging */
	public static void fd(String tag, String msg) {
		if (CPEDataParser.isDebugBuild())
			Log.d(tag, msg);
	}
	
	@SuppressWarnings("unused")
	public static void v(String tag, String msg) {
		if (CPEDataParser.isDebugBuild())
			Log.v(tag, msg);
		
    	getLogger().log(Level.INFO, tag + "\t" + msg);
	}
	
	@SuppressWarnings("unused")
	public static void v(String tag, String msg, Throwable tr) {
		if (CPEDataParser.isDebugBuild())
			Log.v(tag, msg, tr);
		
		getLogger().log(Level.INFO, tag + "\t" + msg);
	}
	
	@SuppressWarnings("unused")
	public static void d(String tag, String msg) {
		if (CPEDataParser.isDebugBuild())
			Log.d(tag, msg);
		
		getLogger().log(Level.INFO, tag + "\t" + msg);
	}
	
	@SuppressWarnings("unused")
	public static void d(String tag, String msg, Throwable tr) {
		if (CPEDataParser.isDebugBuild())
			Log.d(tag, msg, tr);
		
		getLogger().log(Level.INFO, tag + "\t" + msg);
	}
	
	public static void i(String tag, String msg) {
		if (CPEDataParser.isDebugBuild())
			Log.i(tag, msg);
		
		getLogger().log(Level.INFO, tag + "\t" + msg);
	}
	
	public static void i(String tag, String msg, Throwable tr) {
		if (CPEDataParser.isDebugBuild())
			Log.i(tag, msg, tr);
		
		getLogger().log(Level.INFO, tag + "\t" + msg);
	}
	
	public static void w(String tag, String msg) {
		if (CPEDataParser.isDebugBuild())
			Log.w(tag, msg);
		
		getLogger().log(Level.WARNING, tag + "\t" + msg);
	}
	
	public static void w(String tag, String msg, Throwable tr) {
		if (CPEDataParser.isDebugBuild())
			Log.w(tag, msg, tr);
		
		getLogger().log(Level.WARNING, tag + "\t" + msg, tr);
	}

    /** A sensitive warning msg is only logged on dev builds or in diagnostic + admin mode */
    public static void sw(String tag, String msg) {
		if (CPEDataParser.isDebugBuild())
			Log.w(tag, msg);
		
		getLogger().log(Level.WARNING, tag + "\t" + msg);

    }
	
	public static void w(String tag, Throwable tr) {
		if (CPEDataParser.isDebugBuild())
			Log.w(tag, tr);
		
		getLogger().log(Level.WARNING, tag, tr);
	}
	
	public static void e(String tag, String msg) {
		if (CPEDataParser.isDebugBuild())
			Log.e(tag, msg);
		
		getLogger().log(Level.SEVERE, tag + "\t" + msg);
	}
	
	public static void e(String tag, String msg, Throwable tr) {
		if (CPEDataParser.isDebugBuild())
			Log.e(tag, msg, tr);
		
		getLogger().log(Level.SEVERE, tag + "\t" + msg, tr);
	}

}
