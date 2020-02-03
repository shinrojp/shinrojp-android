
package com.shinro.shinrojp_android.models.NHK;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class NHKProgramList {

    @SerializedName("list")
    @Expose
    private List list;

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

}
