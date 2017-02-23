/**
 * Copyright (C) 2017 - present by wilberding.com
 *
 * Please see distribution for license.
 */
package com.wilberding.brewery;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class HeatTimeTests {

    @Test
    public void basics10() {
        assertThat(HeatTime.heatTime(32.0, 212.0, 10.0)).isEqualTo(66.0);
        assertThat(HeatTime.heatTime(55.0, 165.0, 10.0)).isEqualTo(39.40298507462686);
        assertThat(HeatTime.heatTime(141.0, 212.0, 10.0)).isEqualTo(25.43283582089552);
    }

    @Test
    public void basics14() {
        assertThat(HeatTime.heatTime(32.0, 212.0, 14.0)).isEqualTo(96.0);
        assertThat(HeatTime.heatTime(55.0, 165.0, 14.0)).isEqualTo(55.24749163879599);
        assertThat(HeatTime.heatTime(141.0, 212.0, 14.0)).isEqualTo(41.7);
    }
}
