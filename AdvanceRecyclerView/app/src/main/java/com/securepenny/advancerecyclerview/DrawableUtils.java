package com.securepenny.advancerecyclerview;

import android.graphics.drawable.Drawable;

/**
 * Created by R041708040 on 11/8/2017.
 */

public class DrawableUtils {
    private static final int[] EMPTY_STATE = new int[] {};

    public static void clearState(Drawable drawable) {
        if (drawable != null) {
            drawable.setState(EMPTY_STATE);
        }
    }
}
