package com.mohamedabdallah.mvvmcart.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.mohamedabdallah.mvvmcart.R;
import com.mohamedabdallah.mvvmcart.models.Cart;
import com.mohamedabdallah.mvvmcart.viewModels.CartViewModel;

public class SecondActivity extends AppCompatActivity {


    private EditText edit_title,edit_price,number_qty;
    private Button btn_add_cart;

    private CartViewModel cartViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

         edit_title=findViewById(R.id.cartTitle);
         edit_price=findViewById(R.id.cartPrice);
         number_qty=findViewById(R.id.cartQty);
         btn_add_cart=findViewById(R.id.btn_add_cart);

         cartViewModel=new CartViewModel(getApplication());

         btn_add_cart.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 saveCart();
             }
         });
    }
    private void saveCart()
    {
        String title=edit_title.getText().toString();
        String price=edit_price.getText().toString();
        String qty=number_qty.getText().toString();

        if(title.trim().isEmpty()|| price.trim().isEmpty() || qty.trim().isEmpty())
        {
            Toast.makeText(this, "please fill alla fields", Toast.LENGTH_SHORT).show();
            return;
        }
        if (Integer.parseInt(qty)>10 || Integer.parseInt(qty)<1)
        {
            Toast.makeText(this, "Quantity must be a number in between 1 ... 10", Toast.LENGTH_SHORT).show();
            return;

        }


        Cart cart=new Cart(title,Integer.parseInt(price), Integer.parseInt(qty));
        cartViewModel.insert(cart);
        finish();
    }
}

