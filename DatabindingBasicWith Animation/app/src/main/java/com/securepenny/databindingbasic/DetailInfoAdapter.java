package com.securepenny.databindingbasic;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;


import com.securepenny.databindingbasic.databinding.ItemBinding;

import java.util.List;

/**
 * Created by R041708040 on 11/26/2017.
 */

public class DetailInfoAdapter extends RecyclerView.Adapter<DetailInfoAdapter.DetailViewHolder> {
    private List<DetailInfo> detailInfoList;
    private Animation animationUp, animationDown;
    private Context context;
    int mExpandedPosition =-1;

    public DetailInfoAdapter(List<DetailInfo> detailInfoList, Context context, Animation animationUp, Animation animationDown) {
        this.detailInfoList = detailInfoList;
        this.context=context;
        this.animationDown = animationDown;
        this.animationUp = animationUp;
    }

    @Override
    public DetailInfoAdapter.DetailViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_detail, parent, false);
        return new DetailViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(DetailInfoAdapter.DetailViewHolder holder, int position) {
        final int pos = position;
        final DetailInfoAdapter.DetailViewHolder mholder = holder;
        ItemBinding binding = holder.binding;
        DetailInfo detailInfo= detailInfoList.get(position);
        binding.setData(detailInfo);
        if (position==mExpandedPosition)
        {
            holder.binding.llcardView.setVisibility(View.VISIBLE);
            mholder.binding.ivShowMore.setImageResource(R.drawable.ic_keyboard_arrow_up_black_24dp);
            mholder.binding.llcardView.startAnimation(animationDown);
        }
        else {
            holder.binding.llcardView.setVisibility(View.GONE);
            mholder.binding.ivShowMore.setImageResource(R.drawable.ic_keyboard_arrow_down_black_24dp);
            mholder.binding.llcardView.startAnimation(animationUp);
        }

        holder.binding.ivShowMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (mExpandedPosition == -1)
                {
                    mholder.binding.llcardView.setVisibility(View.VISIBLE);
                    mholder.binding.ivShowMore.setImageResource(R.drawable.ic_keyboard_arrow_up_black_24dp);
                    mholder.binding.llcardView.startAnimation(animationDown);
                    mExpandedPosition = pos;
                } else if (mExpandedPosition == pos) {
                    mholder.binding.llcardView.setVisibility(View.GONE);
                    mholder.binding.ivShowMore.setImageResource(R.drawable.ic_keyboard_arrow_down_black_24dp);
                    mholder.binding.llcardView.startAnimation(animationUp);
                    mExpandedPosition = -1;
                } else {
                    int prevPosition = mExpandedPosition;
                    mholder.binding.llcardView.setVisibility(View.VISIBLE);
                    mholder.binding.ivShowMore.setImageResource(R.drawable.ic_keyboard_arrow_up_black_24dp);
                    mholder.binding.llcardView.startAnimation(animationDown);
                    mExpandedPosition = pos;
                    notifyItemChanged(prevPosition);
                }
            }
        });
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
