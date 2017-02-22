/**
 * Copyright (C) 2017 - present by wilberding.com
 *
 * Please see distribution for license.
 */
package com.wilberding.brewery;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class VolumeChillerTests {

    @Test
    public void basics() {
        assertThat(VolumeChiller.actualVolume(13.0, 65.0)).isEqualTo(12.7);
        assertThat(VolumeChiller.actualVolume(13.0, 150.0)).isEqualTo(12.585549307270233);
        assertThat(VolumeChiller.actualVolume(13.0, 212.0)).isEqualTo(12.319590314814814);
    }
}
