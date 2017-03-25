/**
 * Copyright (C) 2017 - present by wilberding.com
 *
 * Please see distribution for license.
 */
package com.wilberding.brewery.data;

public final class ReferenceData {

    /**
     * GRAIN ABSORPTION
     */
    public static final double grainAbsorption = 0.13; // gal/lb

    /**
     * SPECIFIC HEAT
     */
    public static final double specificHeatBarley = 0.38; // Btu/lb°F
    public static final double specificHeatWater = 1.0; // Btu/lb°F

    /**
     * ARBITRARY REFERENCE TEMP FOR WATER CALCS
     */
    // degrees F
    public static final double refTemp = 55.0;

    /**
     * DENSITY OF WATER BY TEMPERATURE
     * https://water.usgs.gov/edu/density.html
     */

//    32°/0°	0.99987	62.416
//            39.2°/4.0°	1.00000	62.424
//            40°/4.4°	0.99999	62.423
//            50°/10°	0.99975	62.408
//            60°/15.6°	0.99907	62.366
//            70°/21°	0.99802	62.300
//            80°/26.7°	0.99669	62.217
//            90°/32.2°	0.99510	62.118
//            100°/37.8°	0.99318	61.998
//            120°/48.9°	0.98870	61.719
//            140°/60°	0.98338	61.386
//            160°/71.1°	0.97729	61.006
//            180°/82.2°	0.97056	60.586
//            200°/93.3°	0.96333	60.135
//            212°/100°	0.95865	59.843

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
