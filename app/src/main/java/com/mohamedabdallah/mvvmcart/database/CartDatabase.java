package com.mohamedabdallah.mvvmcart.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.mohamedabdallah.mvvmcart.models.Cart;

@Database(entities = Cart.class,version = 1)
public abstract class CartDatabase extends RoomDatabase
{
    private static CartDatabase instance;

    public abstract CartDao cartDao();  // room generate the code

    public static synchronized CartDatabase getInstance(Context context)
    {
        if (instance==null)
        {
            instance= Room.databaseBuilder(context.getApplicationContext(),
                    CartDatabase.class, "cart_database")
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }
}
