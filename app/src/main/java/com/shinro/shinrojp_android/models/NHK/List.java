
package com.shinro.shinrojp_android.models.NHK;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class List {

    @SerializedName("g1")
    @Expose
    private ArrayList<G1> g1 = null;

    public ArrayList<G1> getG1() {
        return g1;
    }

    public void setG1(ArrayList<G1> g1) {
        this.g1 = g1;
    }

}
