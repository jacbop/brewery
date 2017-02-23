/**
 * Copyright (C) 2017 - present by wilberding.com
 *
 * Please see distribution for license.
 */
package com.wilberding.brewery.lib;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LinearInterpolatorTest {

    // http://www.ajdesigner.com/phpinterpolation/linear_interpolation_equation.php#ajscroll

    @Test
    public void linear() {
        assertThat(LinearInterpolator.y(100, 141, 150, 100.3, 150)).isEqualTo(141.054);
    }
}
