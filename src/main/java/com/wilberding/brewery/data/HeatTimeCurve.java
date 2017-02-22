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
            {32.0, 0.0},
            {55.0, 12.1},
            {65.0, 17.0},
            {75.0, 25.5},
            {212.0, 100.0}
    };

    HeatTimeCurve() {
        this.curve = x -> LinearInterpolator.interpolate(x, data);
    }

    public Curve getCurve() {
        return curve;
    }
}
