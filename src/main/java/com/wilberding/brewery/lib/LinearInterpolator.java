package com.wilberding.brewery.lib;

public class LinearInterpolator {

    // solve for y2
    public static double y(
            double x1,
            double x2,
            double x3,
            double y1,
            double y3
    ) {
        return (((x2 - x1) * (y3 - y1)) / (x3 - x1)) + y1;
    }

    public static double interpolate(double x, double[][] data) {
        for (int i = 0; i < data.length; i++) {
            if (x < data[i][0]) {
                // extrapolate left
                return data[i][1] - data[i][0];
            }
            if (i == data.length - 1) {
                // extrapolate right
                return data[i][1] - data[i][0];
            }
            if (x >= data[i][0] && x > data[i + 1][0]) {
                // have not found correct bucket yet
                continue;
            }
            // found correct bucket where x > data[i] and x < data[i+1]
            double y2 = LinearInterpolator
                    .y(
                            data[i][0],
                            x,
                            data[i + 1][0],
                            data[i][1],
                            data[i + 1][1]
                    );
            return y2 - x;
        }
        // did not find a match
        return data[data.length - 1][1] - data[data.length - 1][0];
    }
}
