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
        assertThat(sut.y(100.0)).isEqualTo(0.29999999999999716);
        assertThat(sut.y(149.0)).isEqualTo(0.006000000000000227);
        assertThat(sut.y(150.0)).isEqualTo(150.0);
        assertThat(sut.y(212.0)).isEqualTo(210.0);
    }
}
