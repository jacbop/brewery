/**
 * Copyright (C) 2017 - present by wilberding.com
 *
 * Please see distribution for license.
 */
package com.wilberding.brewery;

import com.wilberding.brewery.data.ReferenceData;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class VolumeTests {

    @Test
    public void basics() {
        assertThat(Volume.actualVolume(13.0, 55.0, ReferenceData.refTemp)).isEqualTo(13.0);
        assertThat(Volume.actualVolume(13.0, 65.0, ReferenceData.refTemp)).isEqualTo(12.979965555555555);
        assertThat(Volume.actualVolume(13.0, 150.0, ReferenceData.refTemp)).isEqualTo(12.54902963888889);
        assertThat(Volume.actualVolume(13.0, 212.0, ReferenceData.refTemp)).isEqualTo(12.028089305555556);
    }
}
