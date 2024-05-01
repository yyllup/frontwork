package com.example.entity;

import java.io.Serializable;

/**
 * 平台建议表
*/
public class Suggestion implements Serializable {
    private static final long serialVersionUID = 1L;

    /** ID */
    private Integer id;
    private  Integer userId;
    private String content;
    private String time;
    private String avatar;

    public String getAvatar() {
        return avatar;
    }
    private String userName;

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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

    /** 标题 */


}