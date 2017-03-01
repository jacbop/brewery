/**
 * Copyright (C) 2017 - present by wilberding.com
 *
 * Please see distribution for license.
 */
package com.wilberding.brewery.data;

public final class ObservableData {

    // TODO read this data from csv, xml or json; either from local file or rest call

    /**
     * VOLUME ADJUSTMENTS
     */

    // amount at left bottom of kettle when ball valve is opened with no racking arm
    // 1.125, 1.20
    public static final double kettleDeadSpace = 1.125; // gal

    // amount of displacement when chiller is inserted
    public static final double chillerDisplacement = 0.3; // gal

    // grain saturation amount

    /**
     * TEMP CURVE
     */

    // degrees F => degrees F
    public static final double[][] tempCurveData = {
            {0.0, 0.1}, // guess
            {100.0, 100.3}, // guess
            {152.0, 152.0}, // guess
            {211.3, 212.9} // guess
    };

    /**
     * EFFICIENCY
     */

    // SG points => percentage
    public static final double[][] efficiencyData = {
            {50.0, 90.0}, // guess
            {60.0, 85.0}, // guess
            {70.0, 80.0}, // guess
            {80.0, 75.0}, // guess
            {90.0, 70.0}, // guess
            {100.0, 65.0}, // guess
            {110.0, 60.0}, // guess
    };

    /**
     * HEAT TIME BY VOL
     */

    // 14 gal
    public static final double[][] heatTimeData14 = {
            {32.0, 29.0},
            {54.5, 40.0},
            {63.7, 45.0},
            {74.0, 50.0},
            {84.5, 55.0},
            {94.6, 60.0},
            {104.2, 65.0},
            {114.5, 70.0},
            {126.0, 76.0},
            {134.4, 80.0},
            {144.4, 85.0},
            {155.6, 91.0},
            {166.0, 96.0},
            {173.2, 100.0},
            {183.6, 106.0},
            {192.6, 111.0},
            {199.1, 115.0},
            {210.4, 120.0},
            {212.0, 125.0}
    };

    // 10 gal
    public static final double[][] heatTimeData10 = {
            {32.0, 25.0},
            {47.4, 25.0},
            {63.5, 31.0},
            {79.1, 36.0},
            {90.5, 40.0},
            {105.3, 45.0},
            {118.1, 50.0},
            {134.4, 56.0},
            {144.2, 60.0},
            {159.2, 65.0},
            {173.8, 71.0},
            {183.0, 75.0},
            {196.0, 80.0},
            {206.6, 85.0},
            {212.0, 87.0},
    };

}