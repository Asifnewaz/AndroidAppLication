package com.securepenny.retrofitbasic;

import android.graphics.Movie;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by R041708040 on 11/22/2017.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private List<GitHubRepo> gitHubRepoList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView id,  name;

        public MyViewHolder(View view) {
            super(view);
            id = (TextView) view.findViewById(R.id.tvid);
            name = (TextView) view.findViewById(R.id.title);
        }
    }


    public MyAdapter(List<GitHubRepo> moviesList) {
        this.gitHubRepoList = moviesList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        GitHubRepo repo = gitHubRepoList.get(position);
        holder.id.setText(repo.getId());
        holder.name.setText(repo.getName());
    }

    @Override
    public int getItemCount() {
        return gitHubRepoList.size();
    }
}
