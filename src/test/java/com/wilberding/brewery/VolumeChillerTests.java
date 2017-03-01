/**
 * Copyright (C) 2017 - present by wilberding.com
 *
 * Please see distribution for license.
 */
package com.wilberding.brewery;

import com.wilberding.brewery.data.ReferenceData;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class VolumeChillerTests {

    @Test
    public void basics() {
        assertThat(VolumeChiller.actualVolume(13.0, 55.0, ReferenceData.refTemp)).isEqualTo(12.7);
        assertThat(VolumeChiller.actualVolume(13.0, 65.0, ReferenceData.refTemp)).isEqualTo(12.680427888888888);
        assertThat(VolumeChiller.actualVolume(13.0, 150.0, ReferenceData.refTemp)).isEqualTo(12.291968402777776);
        assertThat(VolumeChiller.actualVolume(13.0, 212.0, ReferenceData.refTemp)).isEqualTo(11.886433413888888);
    }
}
