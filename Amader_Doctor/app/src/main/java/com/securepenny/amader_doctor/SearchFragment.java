package com.securepenny.amader_doctor;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by R041708040 on 10/2/2017.
 */

public class SearchFragment extends Fragment{
public static SearchFragment newInstance() {
        SearchFragment fragment = new SearchFragment();
        return fragment;
        }

@Override
public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        }

@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
        Bundle savedInstanceState) {
        return inflater.inflate(R.layout.frame_search, container, false);
        }
        }
