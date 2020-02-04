package com.shinro.shinrojp_android.holders;

import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.textview.MaterialTextView;
import com.shinro.shinrojp_android.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NHKProgramViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.tvProgramTitle) public MaterialTextView tvProgramTitle;
    @BindView(R.id.imvProgramLogo) public ImageView imvProgramLogo;
    public View itemView;

    public NHKProgramViewHolder(@NonNull View itemView) {
        super(itemView);
        this.itemView = itemView;
        ButterKnife.bind(this, itemView);
    }
}
