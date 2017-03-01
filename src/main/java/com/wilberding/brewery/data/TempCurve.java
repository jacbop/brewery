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

    TempCurve() {
        this.curve = x -> LinearInterpolator.interpolate(x, Observables.tempCurveData);
    }

    public Curve getCurve() {
        return curve;
    }
}
