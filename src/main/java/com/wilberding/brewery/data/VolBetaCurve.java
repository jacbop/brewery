/**
 * Copyright (C) 2017 - present by wilberding.com
 *
 * Please see distribution for license.
 */
package com.wilberding.brewery.data;

import com.wilberding.brewery.lib.Temperature;
import com.wilberding.brewery.lib.Curve;
import com.wilberding.brewery.lib.LinearInterpolator;


/**
 * Curve describing the Volumetric Temperature Coefficients - β - for water
 * m^3/m^3*C
 * http://www.engineeringtoolbox.com/volumetric-temperature-expansion-d_315.html
 */
public enum VolBetaCurve {
    INSTANCE;

    private final Curve curve;

    // degrees C => m^3 / m^3 * C
    private double[][] data = {
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

    VolBetaCurve() {
        this.curve = x -> LinearInterpolator.interpolate(Temperature.toC(x), data);
    }

    public Curve getCurve() {
        return curve;
    }
}
