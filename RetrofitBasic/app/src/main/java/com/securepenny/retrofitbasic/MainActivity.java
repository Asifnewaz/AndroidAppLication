package com.securepenny.retrofitbasic;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ListView;
import android.widget.Toast;

import com.securepenny.retrofitbasic.databinding.MainBinding;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    MainBinding binding;
    private ListView listView;
    private List<GitHubRepo> movieList = new ArrayList<>();
    private MyAdapter mAdapter;
    RecyclerView recycler_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        setContentView(binding.getRoot());

        recycler_view =(RecyclerView) findViewById(R.id.recycler_view);

        ApiInterface client =  ApiClient.createService(ApiInterface.class);

        // Fetch a list of the Github repositories.
        Call<List<GitHubRepo>> call = client.reposForUser("Asifnewaz");
        // Execute the call asynchronously. Get a positive or negative callback.
        call.enqueue(new Callback<List<GitHubRepo>>() {
            @Override
            public void onResponse(Call<List<GitHubRepo>> call, Response<List<GitHubRepo>> response) {
                // The network call was a success and we got a response
                List<GitHubRepo> resp =response.body();

                mAdapter = new MyAdapter(resp);
                RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
                recycler_view.setLayoutManager(mLayoutManager);
                recycler_view.addItemDecoration(new DividerItemDecoration(MainActivity.this, LinearLayoutManager.VERTICAL)); // Set divider
                recycler_view.setAdapter(mAdapter);
            }

            @Override
            public void onFailure(Call<List<GitHubRepo>> call, Throwable t) {
                // the network call was a failure
                Toast.makeText(MainActivity.this,"Error",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
