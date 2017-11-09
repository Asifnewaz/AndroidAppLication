package com.securepenny.myrecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<MyMovie> movieList = new ArrayList<>();
    private RecyclerView recyclerView;
    private MoviesAdapter mAdapter;
    ItemTouchHelper mItemTouchHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        mAdapter = new MoviesAdapter(movieList);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
        // Swiping and drag an drop
        ItemTouchHelper.Callback callback = new EditItemTouchHelperCallback(mAdapter);
        mItemTouchHelper = new ItemTouchHelper(callback);
        mItemTouchHelper.attachToRecyclerView(recyclerView);

        prepareMovieData();
    }

    private void prepareMovieData() {
        MyMovie movie = new MyMovie("Mad Max: Fury Road", "Action & Adventure", "2015");
        movieList.add(movie);

        movie = new MyMovie("Inside Out", "Animation, Kids & Family", "2015");
        movieList.add(movie);

        movie = new MyMovie("Shaun the Sheep", "Animation", "2015");
        movieList.add(movie);

        movie = new MyMovie("The Martian", "Science Fiction & Fantasy", "2015");
        movieList.add(movie);

        movie = new MyMovie("Mission: Impossible Rogue Nation", "Action", "2015");
        movieList.add(movie);

        movie = new MyMovie("Up", "Animation", "2009");
        movieList.add(movie);

        movie = new MyMovie("Star Trek", "Science Fiction", "2009");
        movieList.add(movie);

        movie = new MyMovie("The LEGO MyMovie", "Animation", "2014");
        movieList.add(movie);

        mAdapter.notifyDataSetChanged();
    }

}
