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
        assertThat(sut.y(50.0)).isEqualTo(9.469565217391304);
        assertThat(sut.y(100.0)).isEqualTo(39.09489051094891);
        assertThat(sut.y(149.0)).isEqualTo(65.74087591240877);
        assertThat(sut.y(150.0)).isEqualTo(66.28467153284672);
        assertThat(sut.y(212.0)).isEqualTo(100.0);
    }
}
