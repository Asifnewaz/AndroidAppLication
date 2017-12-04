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
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.securepenny.databindingbasic.databinding.DetailBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<DetailInfo> infoList = new ArrayList<>();

    DetailBinding binding;
    private DetailInfoAdapter adapter;
    private Animation animationUp, animationDown;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.inflate(getLayoutInflater(), R.layout.activity_main, null, false);
        DetailInfo detailInfo = new DetailInfo("Mr.","Asif", "24","Player");
        binding.setData(detailInfo);
        setContentView(binding.getRoot());

        prepareMovieData();
        animationUp = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_up);
        animationDown = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_down);

        adapter = new DetailInfoAdapter(infoList,context,animationUp, animationDown);
        binding.rvList.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        binding.rvList.setAdapter(adapter);

    }

    private void prepareMovieData() {
        DetailInfo info = new DetailInfo("Mr.","Asif", "24","Player");
        infoList.add(info);

        info = new DetailInfo("Dark King", "LUI KANG","","NetheRRealm/Martial Art");
        infoList.add(info);

        info = new DetailInfo("Grand Master", "Sub Zero","","Martial Artisit");
        infoList.add(info);

        info = new DetailInfo("Inferno", "Scorpion","","Martial Artisit");
        infoList.add(info);
    }
}