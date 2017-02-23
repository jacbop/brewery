/**
 * Copyright (C) 2017 - present by wilberding.com
 *
 * Please see distribution for license.
 */
package com.wilberding.brewery.data;

import com.wilberding.brewery.lib.Curve;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class EfficiencyCurveTest {

    @Test
    public void testBasics() {
        Curve sut = EfficiencyCurve.INSTANCE.getCurve();

        assertThat(sut.y(114.0)).isEqualTo(60.0);
        assertThat(sut.y(54.0)).isEqualTo(88.0);
        assertThat(sut.y(98.0)).isEqualTo(66.0);
    }
}
