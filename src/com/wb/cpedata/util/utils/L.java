package com.wb.cpedata.util.utils;


import android.view.View;
import android.view.ViewGroup;

/**
 * Logger helper
 */
public class L {
    public static void view(View v) {
        CPEDataParserLogger.i(F.TAG, v + " isClickable: " + v.isClickable());
        CPEDataParserLogger.i(F.TAG, v + " isFocusable: " + v.isFocusable());
        CPEDataParserLogger.i(F.TAG, v + " isFocused: " + v.isFocused());
    }

    public static void viewGroup(ViewGroup vg) {
        view(vg);
        CPEDataParserLogger.i(F.TAG, vg + " hasFocusable: " + vg.hasFocusable());
        CPEDataParserLogger.i(F.TAG, vg + " hasFocus: " + vg.hasFocus());
    }
}
