package com.securepenny.myrecyclerview;

/**
 * Created by R041708040 on 11/5/2017.
 *
 *  // Swiping and drag an drop
 */

public interface ItemTouchHelperAdapter {
    boolean onItemMove(int fromPosition, int toPosition);

    void onItemDismiss(int position);
}
