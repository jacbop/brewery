package com.wilberding.brewery;

import com.martiansoftware.nailgun.NGContext;
import com.wilberding.brewery.data.Constants;
import com.wilberding.brewery.data.VolBetaCurve;

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
                double vol2 = Double.parseDouble(volString);
                double temp2 = Double.parseDouble(tempString);
                double temp1 = Constants.refTemp;
                double beta2 = VolBetaCurve.INSTANCE.getCurve().y(temp2);
                double beta1 = VolBetaCurve.INSTANCE.getCurve().y(temp1);
                double vol1 = vol2 + (vol2 * ((beta1 + beta2) * 0.5) * (temp1 - temp2));
                context.out.println(
                        String.format(
                                "Observed Volume %s @ %s F = Actual %s @ %s F",
                                vol2, temp2, vol1, temp1));
            }
        }
    }

}