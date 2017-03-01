/**
 * Copyright (C) 2017 - present by wilberding.com
 *
 * Please see distribution for license.
 */
package com.wilberding.brewery.data;

import com.wilberding.brewery.lib.Curve;
import com.wilberding.brewery.lib.LinearInterpolator;


public enum TempCurve {
    INSTANCE;

    private final Curve curve;

    // degrees F => degrees F
    private double[][] data = {
            {0.0, 0.1}, // guess
            {100.0, 100.3}, // guess
            {152.0, 152.0}, // guess
            {211.3, 212.9} // guess
    };

    TempCurve() {
        this.curve = x -> LinearInterpolator.interpolate(x, data);
    }

    public Curve getCurve() {
        return curve;
    }
}
