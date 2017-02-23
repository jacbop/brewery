/**
 * Copyright (C) 2017 - present by wilberding.com
 *
 * Please see distribution for license.
 */
package com.wilberding.brewery;

import com.martiansoftware.nailgun.NGContext;
import com.wilberding.brewery.data.EfficiencyCurve;
import com.wilberding.brewery.lib.Curve;

public class Efficiency {

    public static void nailMain(NGContext context) {
        String input = javax.swing.JOptionPane.showInputDialog(null, "Expected Pre Boil Gravity:");
        if (input == null) {
            context.exit(1);
        } else {
            double expectedGravity = Double.parseDouble(input);
            double expectedEfficiency = efficiency(expectedGravity);
            context.out.println(String.format("Expected Pre Boil Gravity %s = Efficiency should be %s", expectedGravity, expectedEfficiency));
        }
    }

    static double normalizeGravity(double gravity) {
        if (gravity < 2.0) {
            return (gravity - 1) * 1000D;
        } else {
            return gravity;
        }
    }

    static double efficiency(double expectedPreBoilGravity) {
        Curve curve = EfficiencyCurve.INSTANCE.getCurve();
        double normalizedGravity = normalizeGravity(expectedPreBoilGravity);
        double expectedEfficiency = curve.y(normalizedGravity);
        return expectedEfficiency;
    }

}