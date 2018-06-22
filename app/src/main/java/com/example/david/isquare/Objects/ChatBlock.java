package com.example.david.isquare.Objects;

/**
 * Created by David on 9/27/2017.
 */

public class ChatBlock {
    private String name;
    private String content;
    private String time;
    private boolean locked;
    private boolean grouped;

    public ChatBlock() {
        this.name = "";
        this.content = "";
        this.time = "";
        this.locked = false;
        this.grouped = false;
    }

    public ChatBlock(String name, String content, String time, boolean locked, boolean grouped) {
        this.name = name;
        this.content = content;
        this.time = time;
        this.locked = locked;
        this.grouped = grouped;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    public boolean isGrouped() {
        return grouped;
    }

    public void setGrouped(boolean grouped) {
        this.grouped = grouped;
    }
}
