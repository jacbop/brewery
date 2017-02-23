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

    // 14 gal
    private double[][] data14 = {
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

    // 14 gal
    private double[][] data10 = {
            {32.0, 29.0},
            {44.5, 35.0},
            {212.0, 95.0}
    };

    HeatTimeSurface() {
        this.surface = (x, y) -> {
            double at10 = LinearInterpolator.interpolate(x, data10);
            double at14 = LinearInterpolator.interpolate(x, data14);
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
