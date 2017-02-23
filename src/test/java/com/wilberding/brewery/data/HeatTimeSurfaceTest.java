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
        assertThat(sut.z(50.0, 10.0)).isEqualTo(36.97014925373134);
        assertThat(sut.z(100.0, 10.0)).isEqualTo(54.88059701492537);
        assertThat(sut.z(149.0, 10.0)).isEqualTo(72.43283582089552);
        assertThat(sut.z(150.0, 10.0)).isEqualTo(72.7910447761194);
        assertThat(sut.z(212.0, 10.0)).isEqualTo(95.0);
    }

    @Test
    public void testBasics13() {
        Surface sut = HeatTimeSurface.INSTANCE.getSurface();
        assertThat(sut.z(50.0, 13.0)).isEqualTo(37.592537313432835);
        assertThat(sut.z(100.0, 13.0)).isEqualTo(60.82952425373134);
        assertThat(sut.z(149.0, 13.0)).isEqualTo(83.70642324093816);
        assertThat(sut.z(150.0, 13.0)).isEqualTo(84.19776119402985);
        assertThat(sut.z(212.0, 13.0)).isEqualTo(117.5);
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
