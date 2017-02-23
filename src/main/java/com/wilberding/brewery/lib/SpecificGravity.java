/**
 * Copyright (C) 2017 - present by wilberding.com
 * <p>
 * Please see distribution for license.
 */
package com.wilberding.brewery.lib;

public class SpecificGravity {

    public static double normalizeGravity(double gravity) {
        if (gravity < 2.0) {
            return (gravity - 1) * 1000D;
        } else {
            return gravity;
        }
    }
}
