package com.example.proiectcolectiv.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name = "post")

public  class Post {
    @Id
    @Column(name = "postID")
    private int postID;
    @Column(name = "userID")
    private String userID;
    @Column(name = "questionID")
    private String questionID;
    @Column(name = "questionContent")
    private String questionContent;
    @Column(name = "likes")
    private Integer likes;
    @Column(name = "dislikes")

    private Integer disikes;
    @Column(name = "date")
    private Date date;
    @Column(name = "category")
    private String category;

    public Post(int postID, String userID, String questionID, String questionContent, int likes, int disikes, Date date, String category) {
        this.postID = postID;
        this.userID = userID;
        this.questionID = questionID;
        this.questionContent = questionContent;
        this.likes = likes;
        this.disikes = disikes;
        this.date = date;
        this.category = category;
    }
    public Post(){}

    public int getPostID() {
        return postID;
    }

    public void setPostID(int postID) {
        this.postID = postID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getQuestionID() {
        return questionID;
    }

    public void setQuestionID(String questionID) {
        this.questionID = questionID;
    }

    public String getQuestionContent() {
        return questionContent;
    }

    public void setQuestionContent(String questionContent) {
        this.questionContent = questionContent;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public Integer getDisikes() {
        return disikes;
    }

    public void setDisikes(Integer disikes) {
        this.disikes = disikes;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}

