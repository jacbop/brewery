/**
 * Copyright (C) 2017 - present by wilberding.com
 *
 * Please see distribution for license.
 */
package com.wilberding.brewery;

import com.martiansoftware.nailgun.NGContext;
import com.wilberding.brewery.data.Constants;
import com.wilberding.brewery.data.VolBetaCurve;
import com.wilberding.brewery.lib.CtoF;
import com.wilberding.brewery.lib.Curve;

public class Volume {

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
                double vol0 = actualVolume(observedVolume, observedTemp);
                context.out.println(
                        String.format(
                                "Observed Volume %s @ %s F = Actual %s @ %s F",
                                observedVolume, observedTemp, vol0, Constants.refTemp));
            }
        }
    }

    static double actualVolume(double observedVolume, double observedTemp) {
        Curve curve = VolBetaCurve.INSTANCE.getCurve();
        double temp1 = CtoF.toC(Constants.refTemp);
        double temp0 =  CtoF.toC(observedTemp);
        double vol0 = observedVolume;
        double beta0 = curve.y(temp0);
        double vol1 = vol0 + (vol0 * beta0 * (temp1 - temp0));
        return vol1;
    }

    static void integrate(double temp0, double temp1, double vol0) {
        boolean heating = temp0 < temp1;
        double t0 = temp0;
        double t1 = (heating) ? Math.min(temp0 + 1.0, temp1) : Math.max(temp0 - 1.0, temp1);
        double v0 = vol0;
        do {
            System.out.println();
        } while (t1 < temp1);
    }

}