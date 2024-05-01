package com.example.entity;

import java.io.Serializable;

/**
 * 招领信息表
*/
public class Find implements Serializable {
    private static final long serialVersionUID = 1L;

    /** ID */
    private Integer id;
    private String name;
    private String img;
    private Integer userId;
    private String status;
    private String content;
    private String time;
    private  String userName;
    private Integer flowerCount;
    private boolean userFlower;//返回当前浏览数据是否被当前登录用户点赞

    public boolean isUserFlower() {
        return userFlower;
    }

    public void setUserFlower(boolean userFlower) {
        this.userFlower = userFlower;
    }

    public Integer getFlowerCount() {
        return flowerCount;
    }

    public void setFlowerCount(Integer flowerCount) {
        this.flowerCount = flowerCount;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


}