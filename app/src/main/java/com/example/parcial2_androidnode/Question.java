package com.example.parcial2_androidnode;

public class Question {
    String id, text;
    boolean state;
    int average;

    public Question() {
    }

    public Question( int average,String id, boolean state, String text) {
        this.id = id;
        this.average = average;
        this.state = state;
        this.text = text;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getAverage() {
        return average;
    }

    public void setAverage(int average) {
        this.average = average;
    }

    public boolean getState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
