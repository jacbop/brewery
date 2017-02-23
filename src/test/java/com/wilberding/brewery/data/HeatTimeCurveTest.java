/**
 * Copyright (C) 2017 - present by wilberding.com
 *
 * Please see distribution for license.
 */
package com.wilberding.brewery.data;

import com.wilberding.brewery.lib.Curve;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class HeatTimeCurveTest {

    @Test
    public void testBasics() {
        Curve sut = HeatTimeCurve.INSTANCE.getCurve();
        assertThat(sut.y(50.0)).isEqualTo(37.8);
        assertThat(sut.y(100.0)).isEqualTo(62.8125);
        assertThat(sut.y(149.0)).isEqualTo(87.46428571428571);
        assertThat(sut.y(150.0)).isEqualTo(88.0);
        assertThat(sut.y(212.0)).isEqualTo(125.0);
    }
}
