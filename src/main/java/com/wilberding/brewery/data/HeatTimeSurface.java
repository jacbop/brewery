/**
 * Copyright (C) 2017 - present by wilberding.com
 * <p>
 * Please see distribution for license.
 */
package com.wilberding.brewery.data;

import com.wilberding.brewery.lib.LinearInterpolator;
import com.wilberding.brewery.lib.Surface;

public enum HeatTimeSurface {
    INSTANCE;

    private final Surface surface;

    HeatTimeSurface() {
        this.surface = (x, y) -> {
            double at10 = LinearInterpolator.interpolate(x, ObservableData.heatTimeData10);
            double at14 = LinearInterpolator.interpolate(x, ObservableData.heatTimeData14);
            double[][] curves = {{10.0, at10}, {14.0, at14}};
            double z = LinearInterpolator.interpolate(y, curves);
            return z;
        };
    }

    public Surface getSurface() {
        return surface;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
