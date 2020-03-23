package com.shinro.shinrojp_android.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class ItemGrammar {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("content")
    @Expose
    private String content;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public ItemGrammar(String id, String content) {
        this.id = id;
        this.content = content;
    }
}
