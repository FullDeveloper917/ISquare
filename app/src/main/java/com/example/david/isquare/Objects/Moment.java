package com.example.david.isquare.Objects;

import android.graphics.drawable.Drawable;

/**
 * Created by David on 9/26/2017.
 */

public class Moment {
    private String makerName;
    private String makerPhotoUrl;
    private String detailTitle;
    private String detailContent;
    private String imageUrl;
    private Drawable imageDrawable;
    private int likes;
    private int madeTime;
    private boolean stared;
    private boolean loved;
    private boolean followed;

    public Moment(boolean stared, boolean loved, Drawable imageDrawable) {
        this.makerName = "";
        this.makerPhotoUrl = "";
        this.detailTitle = "";
        this.detailContent = "";
        imageUrl = "";
        this.likes = 0;
        this.madeTime = 0;
        this.stared = stared;
        this.loved = loved;
        this.imageDrawable = imageDrawable;
        this.followed = true;
    }

    public Moment(Drawable imageDrawable) {
        this.makerName = "";
        this.makerPhotoUrl = "";
        this.detailTitle = "";
        this.detailContent = "";
        imageUrl = "";
        this.likes = 0;
        this.madeTime = 0;
        this.stared = false;
        this.loved = false;
        this.followed = true;
        this.imageDrawable = imageDrawable;
    }

    public boolean isStared() {
        return stared;
    }

    public void setStared(boolean stared) {
        this.stared = stared;
    }

    public boolean isLoved() {
        return loved;
    }

    public void setLoved(boolean loved) {
        this.loved = loved;
    }

    public boolean isFollowed() {
        return followed;
    }

    public void setFollowed(boolean followed) {
        this.followed = followed;
    }

    public String getMakerName() {
        return makerName;
    }

    public void setMakerName(String makerName) {
        this.makerName = makerName;
    }

    public String getMakerPhotoUrl() {
        return makerPhotoUrl;
    }

    public void setMakerPhotoUrl(String makerPhotoUrl) {
        this.makerPhotoUrl = makerPhotoUrl;
    }

    public String getDetailTitle() {
        return detailTitle;
    }

    public void setDetailTitle(String detailTitle) {
        this.detailTitle = detailTitle;
    }

    public String getDetailContent() {
        return detailContent;
    }

    public void setDetailContent(String detailContent) {
        this.detailContent = detailContent;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getMadeTime() {
        return madeTime;
    }

    public void setMadeTime(int madeTime) {
        this.madeTime = madeTime;
    }

    public Drawable getImageDrawable() {
        return imageDrawable;
    }

    public void setImageDrawable(Drawable imageDrawable) {
        this.imageDrawable = imageDrawable;
    }
}
