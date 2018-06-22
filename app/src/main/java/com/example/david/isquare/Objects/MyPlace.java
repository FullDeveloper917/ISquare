package com.example.david.isquare.Objects;

/**
 * Created by David on 9/27/2017.
 */

public class MyPlace {
    private String title;
    private int commentNumber;

    public MyPlace() {
        this.title = "";
        this.commentNumber = 0;
    }

    public MyPlace(String title, int commentNumber) {
        this.title = title;
        this.commentNumber = commentNumber;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCommentNumber() {
        return commentNumber;
    }

    public void setCommentNumber(int commentNumber) {
        this.commentNumber = commentNumber;
    }
}
