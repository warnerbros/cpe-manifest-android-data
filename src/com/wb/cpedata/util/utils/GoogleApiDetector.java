package com.wb.cpedata.util.utils;


public class GoogleApiDetector {
    private static GoogleApiDetector INSTANCE = new GoogleApiDetector();

    private Boolean isVanillaAndroid;

    private GoogleApiDetector() {
    }

    public static GoogleApiDetector instance() {
        return INSTANCE;
    }

    /** Check for the existence of Google APIs, e.g. Google Maps */
    public boolean isVanillaAndroid() {
        if (isVanillaAndroid == null) {
            try {
                Class.forName("com.google.android.maps.MapActivity");
                isVanillaAndroid = false;
            } catch (ClassNotFoundException e) {
                CPEDataParserLogger.w(F.TAG, "GoogleApiDetector.isVanillaAndroid true", e);
                isVanillaAndroid = true;
            } catch (Error e) {
                CPEDataParserLogger.e(F.TAG, "GoogleApiDetector.isVanillaAndroid true", e);
                isVanillaAndroid = true;
            }
        }
        return isVanillaAndroid;
    }
}
