package com.wilberding.brewery.data;

import com.wilberding.brewery.lib.Curve;
import com.wilberding.brewery.lib.LinearInterpolator;


public enum TempCurve {
    INSTANCE;

    private final Curve curve;

    private double[][] data = {
            {0.0, 0.1},
            {100.0, 100.3},
            {150.0, 150.0},
            {212.0, 210.0}
    };

    private TempCurve() {
        this.curve = x -> LinearInterpolator.interpolate(x, data);
    }

    public Curve getCurve() {
        return curve;
    }
}
