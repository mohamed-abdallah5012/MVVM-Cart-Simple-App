package com.mohamedabdallah.mvvmcart.models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "cart_table")
public class Cart {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String title;

    private int price;

    private int quantity;

    public Cart(String title, int price, int quantity) {
        this.title = title;
        this.price = price;
        this.quantity = quantity;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }
}
