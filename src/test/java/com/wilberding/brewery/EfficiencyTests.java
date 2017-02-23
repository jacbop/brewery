/**
 * Copyright (C) 2017 - present by wilberding.com
 *
 * Please see distribution for license.
 */
package com.wilberding.brewery;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class EfficiencyTests {

    @Test
    public void basics() {
        assertThat(Efficiency.efficiency(54.0)).isEqualTo(88.0);
        assertThat(Efficiency.efficiency(98.0)).isEqualTo(66.0);
        assertThat(Efficiency.efficiency(114.0)).isEqualTo(60.0);

        assertThat(Efficiency.efficiency(1.054)).isEqualTo(87.99999999999997);
        assertThat(Efficiency.efficiency(1.098)).isEqualTo(65.99999999999996);
        assertThat(Efficiency.efficiency(1.114)).isEqualTo(60.0);
    }
}
