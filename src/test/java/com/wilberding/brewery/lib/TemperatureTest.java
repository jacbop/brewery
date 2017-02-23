/**
 * Copyright (C) 2017 - present by wilberding.com
 *
 * Please see distribution for license.
 */
package com.wilberding.brewery.lib;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TemperatureTest {

    @Test
    public void toC() {
        assertThat(Temperature.toC(32d)).isEqualTo(0d);
        assertThat(Temperature.toC(50d)).isEqualTo(10d);
        assertThat(Temperature.toC(72d)).isEqualTo(22.22222222222222);
        assertThat(Temperature.toC(150d)).isEqualTo(65.55555555555556);
        assertThat(Temperature.toC(212d)).isEqualTo(100d);
    }

    @Test
    public void toF() {
        assertThat(Temperature.toF(0d)).isEqualTo(32d);
        assertThat(Temperature.toF(10d)).isEqualTo(50d);
        assertThat(Temperature.toF(22d)).isEqualTo(71.6);
        assertThat(Temperature.toF(65d)).isEqualTo(149d);
        assertThat(Temperature.toF(100d)).isEqualTo(212d);
    }
}
