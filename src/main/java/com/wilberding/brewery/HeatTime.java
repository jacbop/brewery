/**
 * Copyright (C) 2017 - present by wilberding.com
 * <p>
 * Please see distribution for license.
 */
package com.wilberding.brewery;

import com.martiansoftware.nailgun.NGContext;
import com.wilberding.brewery.data.HeatTimeSurface;
import com.wilberding.brewery.lib.Surface;

public class HeatTime {

    public static void nailMain(NGContext context) {
        String startString = javax.swing.JOptionPane.showInputDialog(null, "Start Temp (F):");
        if (startString == null) {
            context.exit(1);
        } else {
            String targetString = javax.swing.JOptionPane.showInputDialog(null, "Target Temp (F):");
            if (targetString == null) {
                context.exit(1);
            } else {
                String volString = javax.swing.JOptionPane.showInputDialog(null, "Volume (gal):");
                if (volString == null) {
                    context.exit(1);
                } else {
                    double startTemp = Double.parseDouble(startString);
                    double targetTemp = Double.parseDouble(targetString);
                    double volume = Double.parseDouble(volString);
                    double time = heatTime(startTemp, targetTemp, volume);
                    context.out.println(
                            String.format(
                                    "Start temp %s F to %s F for %s gal = Actual %s mins",
                                    startTemp, targetTemp, volume, time));
                    context.exit(0);
                }
            }
        }
    }

    static double heatTime(double startTemp, double targetTemp, double volume) {
        Surface surface = HeatTimeSurface.INSTANCE.getSurface();
        double startTime = surface.z(startTemp, volume);
        double endTime = surface.z(targetTemp, volume);
        double time = endTime - startTime;
        return time;
    }

}