/**
 * Copyright (C) 2017 - present by wilberding.com
 *
 * Please see distribution for license.
 */
package com.wilberding.brewery.data;

import com.wilberding.brewery.lib.Curve;
import com.wilberding.brewery.lib.LinearInterpolator;


public enum HeatTimeCurve {
    INSTANCE;

    private final Curve curve;

    // 14 gal
    private double[][] data = {
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

    HeatTimeCurve() {
        this.curve = x -> LinearInterpolator.interpolate(x, data);
    }

    public Curve getCurve() {
        return curve;
    }
}
