package com.wilberding.brewery.data;

import com.wilberding.brewery.lib.CtoF;
import com.wilberding.brewery.lib.Curve;
import com.wilberding.brewery.lib.LinearInterpolator;


/**
 * Curve describing the Volumetric Temperature Coefficients - β - for water
 * http://www.engineeringtoolbox.com/volumetric-temperature-expansion-d_315.html
 */
public enum VolBetaCurve {
    INSTANCE;

    private final Curve curve;

    private double[][] data = {
            {0.0, -0.000050},
            {4.0, 0.0},
            {10.0, 0.000088},
            {20.0, 0.000207},
            {30.0, 0.000303},
            {40.0, 0.000385},
            {50.0, 0.000457},
            {60.0, 0.000522},
            {70.0, 0.000582},
            {80.0, 0.000640},
            {90.0, 0.000695},
    };

    private VolBetaCurve() {
        this.curve = x -> LinearInterpolator.interpolate(CtoF.toC(x), data);
    }

    public Curve getCurve() {
        return curve;
    }
}
