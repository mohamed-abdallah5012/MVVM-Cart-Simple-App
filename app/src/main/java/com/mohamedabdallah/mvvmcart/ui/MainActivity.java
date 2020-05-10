package com.mohamedabdallah.mvvmcart.ui;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.mohamedabdallah.mvvmcart.adapters.CartAdapter;
import com.mohamedabdallah.mvvmcart.R;
import com.mohamedabdallah.mvvmcart.models.Cart;
import com.mohamedabdallah.mvvmcart.viewModels.CartViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    public CartViewModel cartViewModel;
    List<Cart> carts=new ArrayList<>();

    Button btn_delete;
    TextView tv;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        cartViewModel= new CartViewModel(getApplication());

        btn_delete=findViewById(R.id.btn_delete);
        tv=findViewById(R.id.txt_view);
        btn = findViewById(R.id.btn_add);

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        final CartAdapter adapter= new CartAdapter(this,carts);
        recyclerView.setAdapter(adapter);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // launch second activity
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);

            }
        });

        btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // call delete all item
                cartViewModel.delete();
            }
        });


        cartViewModel.getAllCarts().observe(this, new Observer<List<Cart>>() {
            @Override
            public void onChanged(List<Cart> carts) {
             // update the recyclerView
                adapter.setCart(carts);
            }
        });
        cartViewModel.getTotalPrice().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                // update the total price
                if(integer==null)
                    tv.setText("0");
                else
                    tv.setText(integer.toString());
            }
        });
    }

}
