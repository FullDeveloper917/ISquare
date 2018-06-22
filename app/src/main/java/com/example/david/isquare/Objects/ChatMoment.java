package com.example.david.isquare.Objects;

import com.example.david.isquare.Adapters.SingleChatListAdapter;

/**
 * Created by David on 9/26/2017.
 */

public class ChatMoment implements ChatContent{
    private String makerName;
    private String makerPhotoUrl;
    private String detailTitle;
    private String detailContent;
    private String imageUrl;
    private int likes;
    private int madeTime;

    public ChatMoment() {
        this.makerName = "";
        this.makerPhotoUrl = "";
        this.detailTitle = "";
        this.detailContent = "";
        imageUrl = "";
        this.likes = 0;
        this.madeTime = 0;
    }

    public ChatMoment(String makerName, String makerPhotoUrl, String detailTitle, String detailContent, String imageUrl, int likes, int madeTime) {
        this.makerName = makerName;
        this.makerPhotoUrl = makerPhotoUrl;
        this.detailTitle = detailTitle;
        this.detailContent = detailContent;
        this.imageUrl = imageUrl;
        this.likes = likes;
        this.madeTime = madeTime;
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

    @Override
    public int getViewType() {
        return SingleChatListAdapter.RowType.MOMENT.ordinal();
    }
}
