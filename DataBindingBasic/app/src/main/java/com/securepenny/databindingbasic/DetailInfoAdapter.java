package com.securepenny.databindingbasic;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.securepenny.databindingbasic.databinding.ItemBinding;

import java.util.List;

/**
 * Created by R041708040 on 11/26/2017.
 */

public class DetailInfoAdapter extends RecyclerView.Adapter<DetailInfoAdapter.DetailViewHolder> {
    private List<DetailInfo> detailInfoList;
    private Context context;

    public DetailInfoAdapter(List<DetailInfo> detailInfoList, Context context) {
        this.detailInfoList = detailInfoList;
        this.context=context;
    }

    @Override
    public DetailInfoAdapter.DetailViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_detail, parent, false);
        return new DetailViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(DetailInfoAdapter.DetailViewHolder holder, int position) {
        ItemBinding binding = holder.binding;
        DetailInfo detailInfo= detailInfoList.get(position);
        binding.setData(detailInfo);
    }

    @Override
    public int getItemCount() {
        return detailInfoList.size();
    }


    public class DetailViewHolder extends RecyclerView.ViewHolder {
        ItemBinding binding;

        public DetailViewHolder(ItemBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }

    }
}
