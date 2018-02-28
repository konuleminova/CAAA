package com.crocusoft.androidarch.listview;

import android.content.Context;

/**
 * Created by Asus on 2/22/2018.
 */

public class ListObjects {
    private String itemName;
    private String itemContent;
    private int itemImage;

    public ListObjects(String itemName, String itemContent, int itemImage) {
        this.itemName = itemName;
        this.itemContent = itemContent;
        this.itemImage = itemImage;
    }

    public ListObjects() {

    }

    public String getItemContent() {
        return itemContent;
    }

    public void setItemContent(String itemContent) {
        this.itemContent = itemContent;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getItemImage() {
        return itemImage;
    }

    public void setItemImage(int itemImage) {
        this.itemImage = itemImage;
    }

    @Override
    public String toString() {
        return "ListObjects{" +
                "itemName='" + itemName + '\'' +
                ", itemContent='" + itemContent + '\'' +
                ", itemImage=" + itemImage +
                '}';
    }
}
