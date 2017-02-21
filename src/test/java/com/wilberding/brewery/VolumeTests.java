/**
 * Copyright (C) 2017 - present by wilberding.com
 *
 * Please see distribution for license.
 */
package com.wilberding.brewery;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class VolumeTests {

    @Test
    public void basics() {
        assertThat(Volume.actualVolume(13.0, 65.0)).isEqualTo(13.0);
        assertThat(Volume.actualVolume(13.0, 150.0)).isEqualTo(12.88284574759945);
        assertThat(Volume.actualVolume(13.0, 212.0)).isEqualTo(12.61060425925926);
    }
}
