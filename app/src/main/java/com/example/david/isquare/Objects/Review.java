package com.example.david.isquare.Objects;

/**
 * Created by David on 9/28/2017.
 */

public class Review {
    private String title;
    private double mark;
    private String content;

    public Review() {
        this.title = "";
        this.mark = 0.0;
        this.content = "";
    }

    public Review(String title, double mark, String content) {
        this.title = title;
        this.mark = mark;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getMark() {
        return mark;
    }

    public void setMark(double mark) {
        this.mark = mark;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
