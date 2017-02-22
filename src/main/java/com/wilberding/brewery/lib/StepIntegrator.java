/**
 * Copyright (C) 2017 - present by wilberding.com
 * <p>
 * Please see distribution for license.
 */
package com.wilberding.brewery.lib;

import com.google.common.base.Preconditions;

import java.util.function.DoubleBinaryOperator;

public class StepIntegrator {

    public static double integrate(double a, double b, double step, DoubleBinaryOperator f) {
        Preconditions.checkArgument(a > 0D);
        Preconditions.checkArgument(b > 0D);
        Preconditions.checkArgument(step > 0D);
        Preconditions.checkArgument(a < b);
        Preconditions.checkArgument(a + step < b);

        double total = 0.0;
        for (double x0 = a; x0 < b; x0 = x0 + step) {
            double x1 = Math.min(x0 + step, b);
            double slice = f.applyAsDouble(x0, x1);
            total = total + slice;
        }

        return total;
    }
}
