package com.mohamedabdallah.mvvmcart.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.mohamedabdallah.mvvmcart.models.Cart;

import java.util.List;

@Dao
public interface CartDao
{
    @Insert
    void insert (Cart cart);

    @Delete
    void delete(Cart cart);

    @Query("delete from cart_table")
    void delete();

    @Update
    void update(Cart cart);

    @Query("select * from cart_table order by price desc ")
    LiveData<List<Cart>> getAllCarts();

    @Query("select sum(price*quantity) from cart_table ")
    LiveData<Integer> getTotalPrice();

}
