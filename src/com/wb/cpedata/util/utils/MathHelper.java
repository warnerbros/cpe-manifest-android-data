package com.wb.cpedata.util.utils;

import java.util.Random;

public class MathHelper {
    private static Random r = new Random();

    public static long randomId() {
        return Math.abs(r.nextLong());
    }
}
