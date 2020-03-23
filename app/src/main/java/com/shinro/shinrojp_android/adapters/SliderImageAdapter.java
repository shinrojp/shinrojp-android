package com.shinro.shinrojp_android.adapters;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Priority;
import com.shinro.shinrojp_android.R;
import com.shinro.shinrojp_android.holders.SliderImageViewHolder;
import com.shinro.shinrojp_android.utils.ImageViewUtils;
import com.smarteist.autoimageslider.SliderViewAdapter;

public class SliderImageAdapter extends SliderViewAdapter<SliderImageViewHolder> {

    private Context mContext;
    private int mCount;

    public SliderImageAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public SliderImageViewHolder onCreateViewHolder(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_image_slider, null);
        return new SliderImageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SliderImageViewHolder viewHolder, int position) {
        switch (position) {
            case 0:
                ImageViewUtils.loadImage(viewHolder.itemView, viewHolder.backgroundImage, "https://images.pexels.com/photos/218983/pexels-photo-218983.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260", Priority.NORMAL);
                break;
            case 2:
                ImageViewUtils.loadImage(viewHolder.itemView, viewHolder.backgroundImage, "https://images.pexels.com/photos/929778/pexels-photo-929778.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260", Priority.NORMAL);
                break;
            case 1:
            default:
                ImageViewUtils.loadImage(viewHolder.itemView, viewHolder.backgroundImage, "https://images.pexels.com/photos/747964/pexels-photo-747964.jpeg?auto=compress&cs=tinysrgb&h=750&w=1260", Priority.NORMAL);
                break;
        }
    }

    @Override
    public int getCount() {
        return mCount;
    }

    public void setCount(int count) {
        this.mCount = count;
    }
}
