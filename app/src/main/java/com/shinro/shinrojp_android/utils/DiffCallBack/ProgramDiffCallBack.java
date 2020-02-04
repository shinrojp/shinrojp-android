package com.shinro.shinrojp_android.utils.DiffCallBack;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DiffUtil;


import com.shinro.shinrojp_android.models.NHK.G1;

import java.util.ArrayList;

public class ProgramDiffCallBack extends DiffUtil.Callback {

    ArrayList<G1> newList;
    ArrayList<G1> oldList;

    public ProgramDiffCallBack(ArrayList<G1> newList, ArrayList<G1> oldList) {
        this.newList = newList;
        this.oldList = oldList;
    }

    @Override
    public int getOldListSize() {
        return (oldList != null) ? oldList.size() : 0;
    }

    @Override
    public int getNewListSize() {
        return (newList != null) ? newList.size() :0;
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        return newList.get(newItemPosition).getId() == oldList.get(oldItemPosition).getId();
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        int result = newList.get(newItemPosition).compareTo(oldList.get(oldItemPosition));
        return result == 0;
    }

    @Nullable
    @Override
    public Object getChangePayload(int oldItemPosition, int newItemPosition) {
        G1 newG1 = newList.get(newItemPosition);
        G1 oldG1 = oldList.get(oldItemPosition);
        Bundle diff = new Bundle();
        if(newG1.getTitle().equals(oldG1.getTitle())) {
            diff.putString("title", newG1.getTitle());
        }
        if(diff.size() == 0) {
            return null;
        }
        return diff;
    }

}
