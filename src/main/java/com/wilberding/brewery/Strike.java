/**
 * Copyright (C) 2017 - present by wilberding.com
 *
 * Please see distribution for license.
 */
package com.wilberding.brewery;

import com.martiansoftware.nailgun.NGContext;
import com.wilberding.brewery.data.ObservableData;
import com.wilberding.brewery.data.ReferenceData;

public class Strike {

    public static void nailMain(NGContext context) {
        String targetString = javax.swing.JOptionPane.showInputDialog(null, "Target Temp (F):");
        if (targetString == null) {
            context.exit(1);
        } else {
            String grainString = javax.swing.JOptionPane.showInputDialog(null, "Grain Temp (F):");
            if (grainString == null) {
                context.exit(1);
            } else {
                String grainWeightString = javax.swing.JOptionPane.showInputDialog(null, "Grain Weight (lbs):");
                if (grainWeightString == null) {
                    context.exit(1);
                } else {
                    double targetTemp = Double.parseDouble(targetString);
                    double grainTemp = Double.parseDouble(grainString);
                    double grainWeight = Double.parseDouble(grainWeightString);
                    double waterToGrainRatio = ObservableData.waterToGrainRatio;
                    double tunThermalMass = ObservableData.mashTunThermalMass;
                    double tunTemp = grainTemp; // TODO should be separate
                    double strikeTemp = strikeTemp(grainTemp, grainWeight, targetTemp, waterToGrainRatio, tunThermalMass, tunTemp);
                    double strikeVol = strikeVolume(grainWeight);
                    context.out.println(
                            String.format(
                                    "Target temp %s F\n" +
                                            "with %s lbs @ %s F\n" +
                                            "with water/grain of %s qt/lb\n" +
                                            "with mash tun @ %s F and thermal mass of %s lbs\n\n" +
                                            "Strike = %s gal @ %s F",
                                    targetTemp, grainWeight, grainTemp, waterToGrainRatio, tunTemp, tunThermalMass, strikeVol, strikeTemp));
                    context.exit(0);
                }
            }
        }
    }

    // http://hyperphysics.phy-astr.gsu.edu/hbase/thermo/spht.html
    // Q = cmΔT
    static double strikeTemp(double grainTemp, double grainWeight, double targetTemp, double waterToGrainRatio, double tunThermalMass, double tunTemp) {
        double deltaT_grain = targetTemp - grainTemp;
        double c_grain = ReferenceData.specificHeatBarley;
        double m_grain = grainWeight;
        double heatRequired_grain = c_grain * m_grain * deltaT_grain; // BTU

        double deltaT_tun = targetTemp - tunTemp;
        double c_tun = ReferenceData.specificHeatWater;
        double m_tun = tunThermalMass;
        double heatRequired_tun = c_tun * m_tun * deltaT_tun; // BTU

        double waterVolQt = waterToGrainRatio * m_grain;
        double waterVol = waterVolQt / 4.0; // qts to gal
        double waterWeight = waterVol * 8.33; // TODO is temp dep
        double heatRequired = heatRequired_grain + heatRequired_tun;
        double tempChange = heatRequired / waterWeight;

        double strikeTemp = targetTemp + tempChange;
        return strikeTemp;
    }

    static double strikeVolume(double grainWeight) {
        double strikeVolQt = ObservableData.waterToGrainRatio * grainWeight;
        double strikeVol = strikeVolQt / 4.0;
        return strikeVol;
    }

    // sparge, loss from mash tun, pumps
}