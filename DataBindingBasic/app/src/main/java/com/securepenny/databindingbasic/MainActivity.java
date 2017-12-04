package com.securepenny.databindingbasic;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.graphics.Movie;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.securepenny.databindingbasic.databinding.DetailBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<DetailInfo> infoList = new ArrayList<>();

    DetailBinding binding;
    private DetailInfoAdapter adapter;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.inflate(getLayoutInflater(), R.layout.activity_main, null, false);
        DetailInfo detailInfo = new DetailInfo("Asif", "24");
        binding.setData(detailInfo);
        setContentView(binding.getRoot());

        prepareMovieData();

        adapter = new DetailInfoAdapter(infoList,context);
        binding.rvList.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        binding.rvList.setAdapter(adapter);

    }

    private void prepareMovieData() {
        DetailInfo info = new DetailInfo("Asif", "24");
        infoList.add(info);

        info = new DetailInfo("Dark King", "3");
        infoList.add(info);

        info = new DetailInfo("Sub Zero", "2");
        infoList.add(info);

        info = new DetailInfo("Scorpion", "1");
        infoList.add(info);
    }
}