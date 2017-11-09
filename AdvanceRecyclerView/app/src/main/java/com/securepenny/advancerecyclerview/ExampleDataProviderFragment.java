package com.securepenny.advancerecyclerview;

import android.support.v4.app.Fragment;
import android.os.Bundle;
/**
 * Created by R041708040 on 11/8/2017.
 */

public class ExampleDataProviderFragment extends Fragment {
    private AbstractDataProvider mDataProvider;

    public ExampleDataProviderFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setRetainInstance(true);  // keep the mDataProvider instance
        mDataProvider = new ExampleDataProvider();
    }

    public AbstractDataProvider getDataProvider() {
        return mDataProvider;
    }
}