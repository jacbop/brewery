/**
 * Copyright (C) 2017 - present by wilberding.com
 *
 * Please see distribution for license.
 */
package com.wilberding.brewery.lib;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class StepIntegratorTest {

    static double parabola(double x0, double x1) {
        double y0 = x0 * x0;
        double y1 = x1 * x1;
        double y = (y0 + y1) * 0.5;
        return (x1 - x0) * y;
    }

    @Test
    public void basics() {
        assertThat(StepIntegrator.integrate(0.1, 10.0, 1.0, StepIntegratorTest::parabola)).isEqualTo(334.95449999999994);
        assertThat(StepIntegrator.integrate(0.1, 10.0, 0.01, StepIntegratorTest::parabola)).isEqualTo(333.3331649999997);
        assertThat(StepIntegrator.integrate(32.1, 189.3, 1.0, StepIntegratorTest::parabola)).isEqualTo(2250157.1000000006);
    }

}
