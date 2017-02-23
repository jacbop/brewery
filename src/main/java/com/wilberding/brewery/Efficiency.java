/**
 * Copyright (C) 2017 - present by wilberding.com
 * <p>
 * Please see distribution for license.
 */
package com.wilberding.brewery;

import com.martiansoftware.nailgun.NGContext;
import com.wilberding.brewery.data.EfficiencyCurve;
import com.wilberding.brewery.lib.Curve;
import com.wilberding.brewery.lib.SpecificGravity;

public class Efficiency {

    public static void nailMain(NGContext context) {
        String input = javax.swing.JOptionPane.showInputDialog(null, "Expected Pre Boil Gravity (SG):");
        if (input == null) {
            context.exit(1);
        } else {
            double expectedGravity = Double.parseDouble(input);
            double expectedEfficiency = efficiency(expectedGravity);
            context.out.println(String.format("Expected Pre Boil Gravity %s SG = Efficiency should be %s%", expectedGravity, expectedEfficiency));
        }
    }

    static double efficiency(double expectedPreBoilGravity) {
        Curve curve = EfficiencyCurve.INSTANCE.getCurve();
        double normalizedGravity = SpecificGravity.normalizeGravity(expectedPreBoilGravity);
        double expectedEfficiency = curve.y(normalizedGravity);
        return expectedEfficiency;
    }

}