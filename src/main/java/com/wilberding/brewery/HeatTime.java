/**
 * Copyright (C) 2017 - present by wilberding.com
 *
 * Please see distribution for license.
 */
package com.wilberding.brewery;

import com.martiansoftware.nailgun.NGContext;
import com.wilberding.brewery.data.HeatTimeCurve;
import com.wilberding.brewery.lib.Curve;

public class HeatTime {

    public static void nailMain(NGContext context) {
        String startString = javax.swing.JOptionPane.showInputDialog(null, "Start Temp:");
        if (startString == null) {
            context.exit(1);
        } else {
            String targetString = javax.swing.JOptionPane.showInputDialog(null, "Target Temp:");
            if (targetString == null) {
                context.exit(1);
            } else {
                double startTemp = Double.parseDouble(startString);
                double targetTemp = Double.parseDouble(targetString);
                double time = heatTime(startTemp, targetTemp);
                context.out.println(
                        String.format(
                                "Start temp %s F to %s F = Actual %s mins",
                                startTemp, targetTemp, time));
                context.exit(0);
            }
        }
    }

    static double heatTime(double startTemp, double targetTemp) {
        Curve curve = HeatTimeCurve.INSTANCE.getCurve();
        double startTime = curve.y(startTemp);
        double endTime = curve.y(targetTemp);
        double time = endTime - startTime;
        return time;
    }

}