/**
 * Copyright (C) 2017 - present by wilberding.com
 *
 * Please see distribution for license.
 */
package com.wilberding.brewery.data;

import com.wilberding.brewery.lib.Curve;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TempCurveTest {

    // Delta on PID =
    // Specific probe =

    @Test
    public void testBasics() {
        Curve sut = TempCurve.INSTANCE.getCurve();
        assertThat(sut.y(50.0)).isEqualTo(50.20000000000000284);
        assertThat(sut.y(100.0)).isEqualTo(100.29999999999999716);
        assertThat(sut.y(149.0)).isEqualTo(149.0173076923077);
        assertThat(sut.y(150.0)).isEqualTo(150.01153846153846);
        assertThat(sut.y(212.0)).isEqualTo(212.9);
    }
}
