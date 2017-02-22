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
    public void basics() {
        assertThat(HeatTime.heatTime(32.0, 212.0)).isEqualTo(100.0);
        assertThat(HeatTime.heatTime(55.0, 165.0)).isEqualTo(62.341605839416054);
        assertThat(HeatTime.heatTime(141.0, 212.0)).isEqualTo(38.60948905109489);
    }
}
