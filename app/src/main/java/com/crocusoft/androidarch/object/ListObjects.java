package com.crocusoft.androidarch.object;

/**
 * Created by Asus on 2/22/2018.
 */

public class ListObjects {
    private String userId;
    private String userName;
    private String userSurname;
    private int userImage;

    public ListObjects() {
    }

    public ListObjects(String userId, String userName, String userSurname, int userImage) {
        this.userId = userId;
        this.userName = userName;
        this.userSurname = userSurname;
        this.userImage = userImage;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserSurname() {
        return userSurname;
    }

    public void setUserSurname(String userSurname) {
        this.userSurname = userSurname;
    }

    public int getUserImage() {
        return userImage;
    }

    public void setUserImage(int userImage) {
        this.userImage = userImage;
    }

    @Override
    public String toString() {
        return "ListObjects{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", userSurname='" + userSurname + '\'' +
                ", userImage=" + userImage +
                '}';
    }
}
