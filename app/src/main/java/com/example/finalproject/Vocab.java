package com.example.finalproject;

public class Vocab {
    private String word;
    private String def;

    public Vocab(String word, String def) {
        this.word = word;
        this.def = def;
    }

    public String getWord() {
        return word;
    }

    public String getDef() {
        return def;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public void setDef(String def) {
        this.def = def;
    }
}
