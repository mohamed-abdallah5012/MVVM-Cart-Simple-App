package com.mohamedabdallah.mvvmcart.repostoriy;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.mohamedabdallah.mvvmcart.database.CartDao;
import com.mohamedabdallah.mvvmcart.database.CartDatabase;
import com.mohamedabdallah.mvvmcart.models.Cart;

import java.util.List;

public class CartRepository {

    private CartDao cartDao;

    private LiveData<List<Cart>> allCarts;
    private LiveData<Integer> totalPrice;


    public CartRepository(Application application)
    {
        CartDatabase database=CartDatabase.getInstance(application);
        cartDao=database.cartDao();
        allCarts=cartDao.getAllCarts();
        totalPrice=cartDao.getTotalPrice();
    }
    public void insert(Cart cart)
    {
        cartDao.insert(cart);
    }
    public void delete(Cart cart)
    {
        cartDao.delete(cart);
    }
    public void delete()
    {
        cartDao.delete();
    }
    public void update(Cart cart)
    {
        cartDao.update(cart);

    }
    public LiveData<List<Cart>> getAllCarts()
    {
        return cartDao.getAllCarts();
    }
    public LiveData<Integer> getTotalPrice()
    {
     return cartDao.getTotalPrice();
    }

}
