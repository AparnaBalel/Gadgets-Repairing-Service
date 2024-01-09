package com.solvd.gadgets_Repairing_Service.bin;

import java.util.Date;

public class Reviews {

    private long reviewID;
    private long requestID;
    private int rating;
    private String comments;
    private Date reviewDate;

    public Reviews() {
    }

    public Reviews(long reviewID, long requestID, int rating, String comments, Date reviewDate) {
        this.reviewID = reviewID;
        this.requestID = requestID;
        this.rating = rating;
        this.comments = comments;
        this.reviewDate = reviewDate;
    }

    public long getReviewID() {
        return reviewID;
    }

    public void setReviewID(long reviewID) {
        this.reviewID = reviewID;
    }

    public long getRequestID() {
        return requestID;
    }

    public void setRequestID(long requestID) {
        this.requestID = requestID;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Date getReviewDate() {
        return reviewDate;
    }

    public void setReviewDate(Date reviewDate) {
        this.reviewDate = reviewDate;
    }

    @Override
    public String toString() {
        return "Reviews{" +
                "reviewID=" + reviewID +
                ", requestID=" + requestID +
                ", rating=" + rating +
                ", comments='" + comments + '\'' +
                ", reviewDate=" + reviewDate +
                '}';
    }
}
