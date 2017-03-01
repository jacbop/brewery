/**
 * Copyright (C) 2017 - present by wilberding.com
 *
 * Please see distribution for license.
 */
package com.wilberding.brewery.data;

public final class ReferenceData {

    /**
     * ARBITRARY REFERENCE TEMP FOR WATER CALCS
     */
    // degrees F
    public static final double refTemp = 55.0;

    /**
     * BETA COEFFICIENT FOR THERMAL EXPANSION
     */
    // degrees C => m^3 / m^3 * C
    public static final double[][] betaCoefficientData = {
            {0.0, -0.000050}, // reference data
            {4.0, 0.0}, // reference data
            {10.0, 0.000088}, // reference data
            {20.0, 0.000207}, // reference data
            {30.0, 0.000303}, // reference data
            {40.0, 0.000385}, // reference data
            {50.0, 0.000457}, // reference data
            {60.0, 0.000522}, // reference data
            {70.0, 0.000582}, // reference data
            {80.0, 0.000640}, // reference data
            {90.0, 0.000695}, // reference data
    };
}
