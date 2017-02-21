/**
 * Copyright (C) 2017 - present by wilberding.com
 *
 * Please see distribution for license.
 */
package com.wilberding.brewery.data;

import com.wilberding.brewery.lib.Curve;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class VolBetaCurveTest {
    //http://www.engineeringtoolbox.com/water-thermal-properties-d_162.html

    @Test
    public void testBasics() {
        Curve sut = VolBetaCurve.INSTANCE.getCurve();
        assertThat(sut.y(32.0)).isEqualTo(-5.0E-5);
        assertThat(sut.y(100.0)).isEqualTo(3.6677777777777777E-4);
        assertThat(sut.y(149.0)).isEqualTo(5.52E-4);
        assertThat(sut.y(150.0)).isEqualTo(5.553333333333334E-4);
        assertThat(sut.y(212.0)).isEqualTo(6.95E-4);
    }
}
