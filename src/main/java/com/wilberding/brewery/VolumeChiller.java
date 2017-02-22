/**
 * Copyright (C) 2017 - present by wilberding.com
 *
 * Please see distribution for license.
 */
package com.wilberding.brewery;

import com.martiansoftware.nailgun.NGContext;
import com.wilberding.brewery.data.Constants;
import com.wilberding.brewery.data.Observables;
import com.wilberding.brewery.data.VolBetaCurve;
import com.wilberding.brewery.lib.CtoF;
import com.wilberding.brewery.lib.Curve;

public class VolumeChiller {

    public static void nailMain(NGContext context) {
        String volString = javax.swing.JOptionPane.showInputDialog(null, "Observed Volume:");
        if (volString == null) {
            context.exit(1);
        } else {
            String tempString = javax.swing.JOptionPane.showInputDialog(null, "Temp:");
            if (tempString == null) {
                context.exit(1);
            } else {
                double observedVolume = Double.parseDouble(volString);
                double observedTemp = Double.parseDouble(tempString);
                double vol1 = actualVolume(observedVolume, observedTemp);
                context.out.println(
                        String.format(
                                "Observed Volume (with chiller) %s @ %s F = Actual %s @ %s F",
                                observedVolume, observedTemp, vol1, Constants.refTemp));
                context.exit(0);
            }
        }
    }

    static double actualVolume(double observedVolume, double observedTemp) {
        Curve curve = VolBetaCurve.INSTANCE.getCurve();
        double vol2 = observedVolume - Observables.chillerDisplacement;
        double temp2 = CtoF.toC(observedTemp);
        double temp1 = CtoF.toC(Constants.refTemp);
        double beta2 = curve.y(temp2);
        double beta1 = curve.y(temp1);
        // double vol1 = vol2 + (vol2 * ((beta1 + beta2) * 0.5) * (temp1 - temp2));
        double vol1 = vol2 + (vol2 * beta2 * (temp1 - temp2));
        return vol1;
    }

}