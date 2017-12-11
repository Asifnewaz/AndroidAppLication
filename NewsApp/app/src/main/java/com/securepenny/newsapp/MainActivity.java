package com.securepenny.newsapp;


import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.gson.Gson;
import com.securepenny.newsapp.Adapter.ListSourceAdapter;
import com.securepenny.newsapp.Common.Common;
import com.securepenny.newsapp.Network.NewsService;
import com.securepenny.newsapp.model.Website;

import dmax.dialog.SpotsDialog;
import io.paperdb.Paper;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView listWebsite;
    RecyclerView.LayoutManager layoutManager;
    NewsService mService;
    ListSourceAdapter adapter;
    SpotsDialog dialog;
    Website website;
    SwipeRefreshLayout swipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //init cache
        Paper.init(this);

        //init Service
        swipeRefreshLayout = (SwipeRefreshLayout)findViewById(R.id.swipell);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                loadWebsiteSource(true);
            }
        });
        mService= Common.getNewsService();

        //init View
        listWebsite = (RecyclerView) findViewById(R.id.list_source);
        listWebsite.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);

        dialog = new SpotsDialog(this);

        loadWebsiteSource(false);
    }


    private void loadWebsiteSource(boolean isRefreshed) {

       if (!isRefreshed)
       {
           String cache = Paper.book().read("cache");
           if (cache!=null && !cache.isEmpty()){
               website = new Gson().fromJson(cache,Website.class);
               adapter = new ListSourceAdapter(getBaseContext(),website);
               adapter.notifyDataSetChanged();
               listWebsite.setAdapter(adapter);
           }
           else {
               dialog.show();
               mService.getSource().enqueue(new Callback<Website>() {
                   @Override
                   public void onResponse(Call<Website> call, Response<Website> response) {
                       adapter = new ListSourceAdapter(getBaseContext(),response.body());
                       adapter.notifyDataSetChanged();
                       listWebsite.setAdapter(adapter);

                       Paper.book().read("cache",new Gson().toJson(response.body()));
                   }

                   @Override
                   public void onFailure(Call<Website> call, Throwable t) {

                   }
               });
           }
       }
       else {
           dialog.show();
           mService.getSource().enqueue(new Callback<Website>() {
               @Override
               public void onResponse(Call<Website> call, Response<Website> response) {
                   adapter = new ListSourceAdapter(getBaseContext(),response.body());
                   adapter.notifyDataSetChanged();
                   listWebsite.setAdapter(adapter);

                   Paper.book().read("cache",new Gson().toJson(response.body()));

                   swipeRefreshLayout.setRefreshing(false);
               }

               @Override
               public void onFailure(Call<Website> call, Throwable t) {

               }
           });

       }
    }

}
