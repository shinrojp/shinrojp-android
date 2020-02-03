
package com.shinro.shinrojp_android.models.NHK;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class List {

    @SerializedName("g1")
    @Expose
    private java.util.List<G1> g1 = null;

    public java.util.List<G1> getG1() {
        return g1;
    }

    public void setG1(java.util.List<G1> g1) {
        this.g1 = g1;
    }

}
