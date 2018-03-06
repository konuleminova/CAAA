package com.crocusoft.androidarch.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Asus on 2/22/2018.
 */

public class User extends UserDetailsResponse {

    private String userId;
    @SerializedName("Username")
    private String username;
    private String name;
    private String surname;
    private int image;
    @SerializedName("Password")
    private String password;

    public User() {
    }

    public User(String userId, String name, String surname, int image) {
        this.userId = userId;
        this.name = name;
        this.surname = surname;
        this.image = image;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", image=" + image +
                ", password='" + password + '\'' +
                '}';
    }
}
