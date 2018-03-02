package com.crocusoft.androidarch.object;

/**
 * Created by Asus on 2/19/2018.
 */

public class RecyclerObjects {
   private String itemName;
   private int itemImage;

    public RecyclerObjects(String itemName, int itemImage) {
        this.itemName = itemName;
        this.itemImage = itemImage;
    }

    public RecyclerObjects() {
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int  getItemImage() {
        return itemImage;
    }

    public void setItemImage(int itemImage) {
        this.itemImage = itemImage;
    }

    @Override
    public String toString() {
        return "RecyclerObjects{" +
                "itemName='" + itemName + '\'' +
                ", itemImage=" + itemImage +
                '}';
    }
}
