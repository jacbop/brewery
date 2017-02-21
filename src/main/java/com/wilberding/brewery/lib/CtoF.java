/**
 * Copyright (C) 2017 - present by wilberding.com
 *
 * Please see distribution for license.
 */
package com.wilberding.brewery.lib;

public class CtoF {

    public static double toF(double c) {
        return ((c * 9D) / 5D) + 32D;
    }

    public static double toC(double f) {
        return ((f - 32) * 5D) / 9D;
    }
}
