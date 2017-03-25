/**
 * Copyright (C) 2017 - present by wilberding.com
 *
 * Please see distribution for license.
 */
package com.wilberding.brewery;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class StrikeTests {

    @Test
    public void basics() {
        assertThat(Strike.strikeTemp(40.0, 20.0, 152.0, 1.33, 8.06, 40.0)).isEqualTo(183.6623491501864);
        assertThat(Strike.strikeTemp(65.0, 20.0, 152.0, 1.33, 8.06, 65.0)).isEqualTo(176.5948605005912);
        assertThat(Strike.strikeTemp(80.0, 20.0, 152.0, 1.33, 8.06, 80.0)).isEqualTo(172.3543673108341);
    }
}
