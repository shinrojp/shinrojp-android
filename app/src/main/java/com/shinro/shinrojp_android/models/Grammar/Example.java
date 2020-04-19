
package com.shinro.shinrojp_android.models.Grammar;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Example {

    private Integer id;
    private Integer grammar_id;
    private String sentence;

    private String vi;

    private String furigana;

    public Example(Integer id, Integer grammar_id, String sentence, String vi, String furigana) {
        this.id = id;
        this.grammar_id = grammar_id;
        this.sentence = sentence;
        this.vi = vi;
        this.furigana = furigana;
    }

    public Example() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGrammar_id() {
        return grammar_id;
    }

    public void setGrammar_id(Integer grammar_id) {
        this.grammar_id = grammar_id;
    }

    public String getSentence() {
        return sentence;
    }

    public void setSentence(String sentence) {
        this.sentence = sentence;
    }

    public String getVi() {
        return vi;
    }

    public void setVi(String vi) {
        this.vi = vi;
    }

    public String getFurigana() {
        return furigana;
    }

    public void setFurigana(String furigana) {
        this.furigana = furigana;
    }
}
