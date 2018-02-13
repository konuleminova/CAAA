package com.crocusoft.androidarch.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Asus on 2/13/2018.
 */

public class LoginResponse {
    @SerializedName("Id")
    private int id;
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

    public void setPageNumber( int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public  int getPageSize() {
        return pageSize;
    }

    public void setPageSize( int pageSize) {
        this.pageSize = pageSize;
    }

    public  int getResultCount() {
        return resultCount;
    }

    public void setResultCount( int resultCount) {
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMessageId() {
        return messageId;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }

    @Override
    public String toString() {
        return "LoginResponse{" +
                "id=" + id +
                ", messageId=" + messageId +
                ", token='" + token + '\'' +
                ", apiKey='" + apiKey + '\'' +
                ", message='" + message + '\'' +
                ", pageNumber='" + pageNumber + '\'' +
                ", pageSize='" + pageSize + '\'' +
                ", resultCount='" + resultCount + '\'' +
                ", filter='" + filter + '\'' +
                ", createDate='" + createDate + '\'' +
                ", updateDate='" + updateDate + '\'' +
                ", deleteDate='" + deleteDate + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
