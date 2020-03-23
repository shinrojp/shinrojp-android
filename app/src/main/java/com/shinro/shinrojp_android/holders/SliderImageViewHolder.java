package com.shinro.shinrojp_android.holders;

import android.view.View;
import android.widget.ImageView;

import com.shinro.shinrojp_android.R;
import com.smarteist.autoimageslider.SliderViewAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SliderImageViewHolder extends SliderViewAdapter.ViewHolder {

    @BindView(R.id.iv_auto_image_slider) public ImageView backgroundImage;
    public View itemView;

    public SliderImageViewHolder(View itemView) {
        super(itemView);
        this.itemView = itemView;
        ButterKnife.bind(this, itemView);
    }

}
