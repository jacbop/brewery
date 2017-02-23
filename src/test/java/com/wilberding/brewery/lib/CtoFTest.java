/**
 * Copyright (C) 2017 - present by wilberding.com
 *
 * Please see distribution for license.
 */
package com.wilberding.brewery.lib;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CtoFTest {

    @Test
    public void toC() {
        assertThat(CtoF.toC(32d)).isEqualTo(0d);
        assertThat(CtoF.toC(50d)).isEqualTo(10d);
        assertThat(CtoF.toC(72d)).isEqualTo(22.22222222222222);
        assertThat(CtoF.toC(150d)).isEqualTo(65.55555555555556);
        assertThat(CtoF.toC(212d)).isEqualTo(100d);
    }

    @Test
    public void toF() {
        assertThat(CtoF.toF(0d)).isEqualTo(32d);
        assertThat(CtoF.toF(10d)).isEqualTo(50d);
        assertThat(CtoF.toF(22d)).isEqualTo(71.6);
        assertThat(CtoF.toF(65d)).isEqualTo(149d);
        assertThat(CtoF.toF(100d)).isEqualTo(212d);
    }
}
