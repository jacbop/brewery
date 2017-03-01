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

    VolBetaCurve() {
        this.curve = x -> LinearInterpolator.interpolate(Temperature.toC(x), ReferenceData.betaCoefficientData);
    }

    public Curve getCurve() {
        return curve;
    }
}
