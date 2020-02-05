package com.shinro.shinrojp_android.adapters;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Priority;
import com.shinro.shinrojp_android.R;
import com.shinro.shinrojp_android.holders.NHKProgramViewHolder;
import com.shinro.shinrojp_android.models.NHK.G1;
import com.shinro.shinrojp_android.utils.CommonUtils;
import com.shinro.shinrojp_android.utils.DiffCallBack.ProgramDiffCallBack;
import com.shinro.shinrojp_android.utils.ImageViewUtils;

import java.util.ArrayList;
import java.util.List;

public class NHKProgramAdapter extends RecyclerView.Adapter<NHKProgramViewHolder> {

    private Context mContext;
    private ArrayList<G1> mPrograms;

    public NHKProgramAdapter(Context mContext, ArrayList<G1> mPrograms) {
        this.mContext = mContext;
        this.mPrograms = mPrograms;
    }

    @NonNull
    @Override
    public NHKProgramViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new NHKProgramViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_nhk_program, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull NHKProgramViewHolder holder, int position) {
        holder.tvProgramTitle.setText(mPrograms.get(position).getTitle());
        ImageViewUtils.loadImage(holder.itemView, holder.imvProgramLogo, CommonUtils.getImageUrlForGlide(mPrograms.get(position).getService().getLogoM().getUrl()), Priority.NORMAL);
        RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) holder.itemView.getLayoutParams();
        if(holder.getAdapterPosition() == 0) {
            params.leftMargin = holder.itemView.getResources().getDimensionPixelSize(R.dimen.activity_vertical_margin);
        }else{
            params.leftMargin = 0;
        }
        holder.itemView.setLayoutParams(params);
    }

    @Override
    public void onBindViewHolder(@NonNull NHKProgramViewHolder holder, int position, @NonNull List<Object> payloads) {
        String title;
        if(payloads.isEmpty()) {
            super.onBindViewHolder(holder, position, payloads);
            return;
        }else{
            Bundle bundle = (Bundle) payloads.get(0);
            for(String k : bundle.keySet()) {
                if(k.equals("title")) {
                    title = bundle.getString(k);
                    holder.tvProgramTitle.setText(title);
                }
            }
        }
    }

    @Override
    public int getItemCount() {
        return (mPrograms != null) ? mPrograms.size() : 0;
    }

    public ArrayList<G1> getProgramData() {
        return mPrograms;
    }

    public void setProgramData(ArrayList<G1> g1s) {
        ProgramDiffCallBack programDiffCallBack = new ProgramDiffCallBack(g1s, mPrograms);
        DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(programDiffCallBack);
        diffResult.dispatchUpdatesTo(this);
        mPrograms.clear();
        mPrograms.addAll(g1s);
    }

}
