package com.crocusoft.androidarch.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Asus on 2/22/2018.
 */

public class User {
    private String userId;
    private String userName;
    private String userSurname;
    private int userImage;

    public User() {
    }

    public User(String userId, String userName, String userSurname, int userImage) {
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

    //Login request
    @SerializedName("Username")
    private String username;
    @SerializedName("Password")
    private String password;
    @SerializedName("ApiKey")
    private String apikey;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getApikey() {
        return apikey;
    }

    public void setApikey(String apikey) {
        this.apikey = apikey;
    }


    // Login response
    public class LoginResponse {
        @SerializedName("Id")
        private Integer id;
        @SerializedName("MessageId")
        private int messageId;
        @SerializedName("Token")
        private String token;
        @SerializedName("ApiKey")
        private String apiKey;
        @SerializedName("Message")
        private String message;
        @SerializedName("PageNumber")
        private int pageNumber;
        @SerializedName("PageSize")
        private int pageSize;
        @SerializedName("ResultCount")
        private int resultCount;
        @SerializedName("Filter")
        private String filter;
        @SerializedName("CreateDate")
        private String createDate;
        @SerializedName("UpdateDate")
        private String updateDate;
        @SerializedName("DeleteDate")
        private String deleteDate;
        @SerializedName("Url")
        private String url;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public int getMessageId() {
            return messageId;
        }

        public void setMessageId(int messageId) {
            this.messageId = messageId;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public String getApiKey() {
            return apiKey;
        }

        public void setApiKey(String apiKey) {
            this.apiKey = apiKey;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public int getPageNumber() {
            return pageNumber;
        }

        public void setPageNumber(int pageNumber) {
            this.pageNumber = pageNumber;
        }

        public int getPageSize() {
            return pageSize;
        }

        public void setPageSize(int pageSize) {
            this.pageSize = pageSize;
        }

        public int getResultCount() {
            return resultCount;
        }

        public void setResultCount(int resultCount) {
            this.resultCount = resultCount;
        }

        public String getFilter() {
            return filter;
        }

        public void setFilter(String filter) {
            this.filter = filter;
        }

        public String getCreateDate() {
            return createDate;
        }

        public void setCreateDate(String createDate) {
            this.createDate = createDate;
        }

        public String getUpdateDate() {
            return updateDate;
        }

        public void setUpdateDate(String updateDate) {
            this.updateDate = updateDate;
        }

        public String getDeleteDate() {
            return deleteDate;
        }

        public void setDeleteDate(String deleteDate) {
            this.deleteDate = deleteDate;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        @Override
        public String toString() {
            return "LoginResponse{" +
                    "id=" + id +
                    ", messageId=" + messageId +
                    ", token='" + token + '\'' +
                    ", apiKey='" + apiKey + '\'' +
                    ", message='" + message + '\'' +
                    ", pageNumber=" + pageNumber +
                    ", pageSize=" + pageSize +
                    ", resultCount=" + resultCount +
                    ", filter='" + filter + '\'' +
                    ", createDate='" + createDate + '\'' +
                    ", updateDate='" + updateDate + '\'' +
                    ", deleteDate='" + deleteDate + '\'' +
                    ", url='" + url + '\'' +
                    '}';
        }

    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", userSurname='" + userSurname + '\'' +
                ", userImage=" + userImage +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", apikey='" + apikey + '\'' +
                '}';
    }
}
