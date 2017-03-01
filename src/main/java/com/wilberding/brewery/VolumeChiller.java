/**
 * Copyright (C) 2017 - present by wilberding.com
 *
 * Please see distribution for license.
 */
package com.wilberding.brewery;

import com.martiansoftware.nailgun.NGContext;
import com.wilberding.brewery.data.ReferenceData;
import com.wilberding.brewery.data.ObservableData;
import com.wilberding.brewery.data.VolBetaCurve;
import com.wilberding.brewery.lib.Curve;
import com.wilberding.brewery.lib.Temperature;

public class VolumeChiller {

    public static void nailMain(NGContext context) {
        String volString = javax.swing.JOptionPane.showInputDialog(null, "Observed Volume (gal):");
        if (volString == null) {
            context.exit(1);
        } else {
            String tempString = javax.swing.JOptionPane.showInputDialog(null, "Temp (F):");
            if (tempString == null) {
                context.exit(1);
            } else {
                double observedVolume = Double.parseDouble(volString);
                double observedTemp = Double.parseDouble(tempString);
                double targetTemp = ReferenceData.refTemp;
                double vol0 = actualVolume(observedVolume, Temperature.toC(observedTemp), Temperature.toC(targetTemp));
                context.out.println(
                        String.format(
                                "Observed Volume (with chiller) %s gal @ %s F = Actual %s gal @ %s F",
                                observedVolume, observedTemp, vol0, ReferenceData.refTemp));
                context.exit(0);
            }
        }
    }

    static double actualVolume(double observedVolumeUnAdjusted, double observedTemp, double targetTemp) {
        double observedVolume = observedVolumeUnAdjusted - ObservableData.chillerDisplacement;
        double duv = deltaUnitVolume(observedTemp, targetTemp);
        double delta = observedVolume * duv;
        double actualVolume = observedVolume + delta;
        return actualVolume;
    }

    static double deltaUnitVolume(double temp0, double temp1) {
        Curve curve = VolBetaCurve.INSTANCE.getCurve();
        double beta1 = curve.y(temp1);
        double beta0 = curve.y(temp0);
        double dv = (((beta0 + beta1) * 0.5) * (temp1 - temp0));
        return dv;
    }
}