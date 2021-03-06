/**
 * Copyright (C) 2017 - present by wilberding.com
 *
 * Please see distribution for license.
 */
package com.wilberding.brewery;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class TempTests {

    @Test
    public void basics() {
        assertThat(Temp.actualTemp(32.0)).isEqualTo(33.37787021630616);
        assertThat(Temp.actualTemp(68.0)).isEqualTo(70.11597222222223);
        assertThat(Temp.actualTemp(152.0)).isEqualTo(152.0);
        assertThat(Temp.actualTemp(212.0)).isEqualTo(212.9);
    }
}
