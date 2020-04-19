
package com.shinro.shinrojp_android.models.Grammar;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Grammar {


    private Integer id;

    private String level;

    private String content;

    private String mean;

    private String use;

    private String note;

    public Grammar(Integer id, String level, String content, String mean, String use, String note) {
        this.id = id;
        this.level = level;
        this.content = content;
        this.mean = mean;
        this.use = use;
        this.note = note;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getMean() {
        return mean;
    }

    public void setMean(String mean) {
        this.mean = mean;
    }

    public String getUse() {
        return use;
    }

    public void setUse(String use) {
        this.use = use;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
