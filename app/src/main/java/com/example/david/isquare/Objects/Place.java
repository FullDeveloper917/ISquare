package com.example.david.isquare.Objects;

/**
 * Created by David on 10/14/2017.
 */

public class Place {
    private int comments;
    private double maxDistance;
    private String description;

    public Place(int comments, double maxDistance, String description) {
        this.comments = comments;
        this.maxDistance = maxDistance;
        this.description = description;
    }

    public int getComments() {
        return comments;
    }

    public void setComments(int comments) {
        this.comments = comments;
    }

    public double getMaxDistance() {
        return maxDistance;
    }

    public void setMaxDistance(double maxDistance) {
        this.maxDistance = maxDistance;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
