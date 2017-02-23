/**
 * Copyright (C) 2017 - present by wilberding.com
 *
 * Please see distribution for license.
 */
package com.wilberding.brewery.data;

import com.wilberding.brewery.lib.Curve;
import com.wilberding.brewery.lib.LinearInterpolator;


public enum EfficiencyCurve {
    INSTANCE;

    private final Curve curve;

    // SG points => percentage
    private double[][] data = {
            {50.0, 90.0}, // guess
            {60.0, 85.0}, // guess
            {70.0, 80.0}, // guess
            {80.0, 75.0}, // guess
            {90.0, 70.0}, // guess
            {100.0, 65.0}, // guess
            {110.0, 60.0}, // guess
    };

    EfficiencyCurve() {
        this.curve = x -> LinearInterpolator.interpolate(x, data);
    }

    public Curve getCurve() {
        return curve;
    }
}
