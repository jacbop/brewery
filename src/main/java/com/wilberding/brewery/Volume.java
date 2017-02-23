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
import com.wilberding.brewery.lib.StepIntegrator;

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
                double targetTemp = Constants.refTemp;
                double targetVolume = actualVolume(observedVolume, observedTemp, targetTemp);
                context.out.println(
                        String.format(
                                "Observed Volume (no chiller) %s @ %s F = Actual %s @ %s F",
                                observedVolume, observedTemp, targetVolume, targetTemp
                        )
                );
                context.exit(0);
            }
        }
    }

    static double actualVolume(double observedVolume, double observedTemp, double targetTemp) {
        double duv = StepIntegrator.integrate(targetTemp, observedTemp, 1, Volume::deltaUnitVolume);
        double duvSign = (observedTemp > targetTemp) ? -1.0 : 1.0;
        double delta = observedVolume * duv * duvSign;
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