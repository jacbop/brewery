/**
 * Copyright (C) 2017 - present by wilberding.com
 * <p>
 * Please see distribution for license.
 */
package com.wilberding.brewery.data;

import com.wilberding.brewery.lib.Surface;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HeatTimeSurfaceTest {

    @Test
    public void testBasics10() {
        Surface sut = HeatTimeSurface.INSTANCE.getSurface();
        assertThat(sut.z(50.0, 10.0)).isEqualTo(25.96894409937888);
        assertThat(sut.z(100.0, 10.0)).isEqualTo(43.20945945945946);
        assertThat(sut.z(149.0, 10.0)).isEqualTo(61.6);
        assertThat(sut.z(150.0, 10.0)).isEqualTo(61.93333333333334);
        assertThat(sut.z(212.0, 10.0)).isEqualTo(87.0);
    }

    @Test
    public void testBasics13() {
        Surface sut = HeatTimeSurface.INSTANCE.getSurface();
        assertThat(sut.z(50.0, 13.0)).isEqualTo(34.842236024844716);
        assertThat(sut.z(100.0, 13.0)).isEqualTo(57.91173986486486);
        assertThat(sut.z(149.0, 13.0)).isEqualTo(80.99821428571428);
        assertThat(sut.z(150.0, 13.0)).isEqualTo(81.48333333333333);
        assertThat(sut.z(212.0, 13.0)).isEqualTo(115.5);
    }

    @Test
    public void testBasics14() {
        Surface sut = HeatTimeSurface.INSTANCE.getSurface();
        assertThat(sut.z(50.0, 14.0)).isEqualTo(37.8);
        assertThat(sut.z(100.0, 14.0)).isEqualTo(62.8125);
        assertThat(sut.z(149.0, 14.0)).isEqualTo(87.46428571428571);
        assertThat(sut.z(150.0, 14.0)).isEqualTo(88.0);
        assertThat(sut.z(212.0, 14.0)).isEqualTo(125.0);
    }

}
