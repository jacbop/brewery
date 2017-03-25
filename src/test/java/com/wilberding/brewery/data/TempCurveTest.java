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
        assertThat(sut.y(50.0)).isEqualTo(52.09667221297837);
        assertThat(sut.y(100.0)).isEqualTo(100.56041666666667);
        assertThat(sut.y(149.0)).isEqualTo(149.0246406570842);
        assertThat(sut.y(150.0)).isEqualTo(150.0164271047228);
        assertThat(sut.y(212.0)).isEqualTo(212.9);
    }
}
