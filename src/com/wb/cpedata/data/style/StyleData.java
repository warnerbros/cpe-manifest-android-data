package com.wb.cpedata.data.style;

/**
 * Created by gzcheng on 9/19/16.
 */
public class StyleData {


    public final static int PHONE_PORTRAIT = 0;
    public final static int PHONE_LANDSCAPE = 1;
    public final static int TABLET_PORTRAIT = 2;
    public final static int TABLE_LANDSCAPE = 3;

    public static enum ScaleMethod{
        BestFit, Full;
    }

    public static enum PositionMethod{
        upperleft, upperright, bottomleft, bottomright, centered;
    }

}
