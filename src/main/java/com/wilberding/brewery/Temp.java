/**
 * Copyright (C) 2017 - present by wilberding.com
 *
 * Please see distribution for license.
 */
package com.wilberding.brewery;

import com.martiansoftware.nailgun.NGContext;
import com.wilberding.brewery.data.TempCurve;
import com.wilberding.brewery.lib.Curve;

public class Temp {

    public static void nailMain(NGContext context) {
        String input = javax.swing.JOptionPane.showInputDialog(null, "Observed Temp (F):");
        if (input == null) {
            context.exit(1);
        } else {
            double observedTemp = Double.parseDouble(input);
            double actualTemp = actualTemp(observedTemp);
            context.out.println(String.format("Observed %s F = Actual %s F", observedTemp, actualTemp));
            context.exit(0);
        }
    }

    static double actualTemp(double observedTemp) {
        Curve curve = TempCurve.INSTANCE.getCurve();
        double actualTemp = curve.y(observedTemp);
        return actualTemp;
    }

}