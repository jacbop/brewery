package com.wilberding.brewery;

import com.martiansoftware.nailgun.NGContext;
import com.wilberding.brewery.data.TempCurve;
import com.wilberding.brewery.lib.Curve;

public class Temp {

    public static void nailMain(NGContext context) {
        String input = javax.swing.JOptionPane.showInputDialog(null, "Observed Temp:");
        if (input == null) {
            context.exit(1);
        } else {
            Curve curve = TempCurve.INSTANCE.getCurve();
            double observedTemp = Double.parseDouble(input);
            double delta = curve.y(observedTemp);
            double actualTemp = observedTemp + delta;
            context.out.println(String.format("Observed %s = Actual %s", observedTemp, actualTemp));
        }
    }

}