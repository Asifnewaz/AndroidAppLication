package com.securepenny.newsapp.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.securepenny.newsapp.Common.Common;
import com.securepenny.newsapp.Interface.IconBetterIdeaService;
import com.securepenny.newsapp.Interface.ItemClickListener;
import com.securepenny.newsapp.R;
import com.securepenny.newsapp.model.IconBetterIdea;
import com.securepenny.newsapp.model.Website;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by R041708040 on 12/7/2017.
 */

public class ListSourceAdapter extends RecyclerView.Adapter<ListSourceAdapter.MyViewHolder> {
    private Context context;
    private Website website;
    IconBetterIdeaService mService;

    public ListSourceAdapter(Context context, Website website) {
        this.context = context;
        this.website = website;

        mService = Common.getIconService();
    }

    @Override
    public ListSourceAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_item, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final ListSourceAdapter.MyViewHolder holder, int position) {
        StringBuilder iconBetterAPi = new StringBuilder("https://icons.better-idea.org/allicons.json?url=");
        iconBetterAPi.append(website.getSources().get(position).getUrl());
        mService.getIconUrl(iconBetterAPi.toString()).enqueue(new Callback<IconBetterIdea>() {
            @Override
            public void onResponse(Call<IconBetterIdea> call, Response<IconBetterIdea> response) {
                if (response.body().getIconList().size()>0){
                    Picasso.with(context)
                    .load(response.body().getIconList().get(0).getUrl())
                    .into(holder.source_image);
                }
            }

            @Override
            public void onFailure(Call<IconBetterIdea> call, Throwable t) {

            }
        });

        holder.source_Title.setText(website.getSources().get(position).getName());
        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int position, boolean isLongClick) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return website.getSources().size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ItemClickListener itemClickListener;
        TextView source_Title;
        CircleImageView source_image;
        public MyViewHolder(View itemView) {
            super(itemView);

            source_Title = (TextView) itemView.findViewById(R.id.source_title);
            source_image = (CircleImageView) itemView.findViewById(R.id.source_image);

            itemView.setOnClickListener(this);
        }

        public void setItemClickListener(ItemClickListener itemClickListener){
            this.itemClickListener=itemClickListener;
        }

        @Override
        public void onClick(View view) {
            itemClickListener.onClick(view,getAdapterPosition(),false);
        }
    }
}
