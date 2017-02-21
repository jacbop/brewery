package com.wilberding.brewery.data;

import com.wilberding.brewery.lib.Curve;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class TempCurveTest {

    // Delta on PID =
    // Specific probe =

    @Test
    public void testBasics() {
        Curve sut = TempCurve.INSTANCE.getCurve();
        assertThat(sut.y(50.0)).isEqualTo(0.20000000000000284);
        assertThat(sut.y(100.0)).isEqualTo(0.29999999999999716);
        assertThat(sut.y(149.0)).isEqualTo(0.006000000000000227);
        assertThat(sut.y(150.0)).isEqualTo(0.0);
        assertThat(sut.y(212.0)).isEqualTo(-2.0);
    }
}
