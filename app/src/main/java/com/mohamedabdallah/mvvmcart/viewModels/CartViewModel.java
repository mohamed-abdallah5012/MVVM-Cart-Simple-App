package com.mohamedabdallah.mvvmcart.viewModels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.mohamedabdallah.mvvmcart.repostoriy.CartRepository;
import com.mohamedabdallah.mvvmcart.models.Cart;

import java.util.List;

public class CartViewModel extends AndroidViewModel {

    private CartRepository cartRepository;
    private LiveData<List<Cart>> allCarts;
    private LiveData<Integer> totalPrice;


    public CartViewModel(@NonNull Application application)
    {
        super(application);
        cartRepository=new CartRepository(application);
        allCarts=cartRepository.getAllCarts();
        totalPrice=cartRepository.getTotalPrice();
    }

    public void insert(Cart cart)
    {
        cartRepository.insert(cart);
    }
    public void delete(Cart cart)
    {
        cartRepository.delete(cart);
    }
    public void delete()
    {
        cartRepository.delete();
    }
    public void update(Cart cart)
    {
        cartRepository.update(cart);

    }
    public LiveData<List<Cart>> getAllCarts()
    {
        return cartRepository.getAllCarts();
    }
    public LiveData<Integer> getTotalPrice()
    {
        return cartRepository.getTotalPrice();
    }

}
