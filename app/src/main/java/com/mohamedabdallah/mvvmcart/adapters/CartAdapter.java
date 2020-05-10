package com.mohamedabdallah.mvvmcart.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.mohamedabdallah.mvvmcart.viewModels.CartViewModel;
import com.mohamedabdallah.mvvmcart.R;
import com.mohamedabdallah.mvvmcart.models.Cart;

import java.util.ArrayList;
import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.MyViewHolder> {


    CartViewModel cartViewModel1=new CartViewModel(null);

    private Context mContext;
    private List<Cart> cartList= new ArrayList<>();
    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        private TextView title, price,quantity;
        private ImageView minus,plus,delete;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.my_cart_title);
            price = (TextView) view.findViewById(R.id.my_cart_price);
            quantity = (TextView) view.findViewById(R.id.my_cart_qty);
            minus = (ImageView) view.findViewById(R.id.my_cart_minus_img);
            plus = (ImageView) view.findViewById(R.id.my_cart_plus_img);
            delete = (ImageView) view.findViewById(R.id.my_cart_delete_img);
        }
    }
    // Provide a suitable constructor (depends on the kind of dataset)
    public CartAdapter(Context mContext, List<Cart> albumList) {
        this.mContext = mContext;
        this.cartList = albumList;
    }
    // Create new views (invoked by the layout manager)
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cart_item, parent, false);

        return new MyViewHolder(itemView);
    }
    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        final Cart album = cartList.get(position);
        holder.title.setText(album.getTitle());
        holder.price.setText(album.getPrice() + " .LE");
        holder.quantity.setText(album.getQuantity()+"");


        // loading album cover using Glide library
        //Glide.with(mContext).load(album.getThumbnail()).into(holder.thumbnail);
        //Picasso.with(getApplicationContext()).load(product.getImage()).into(holder.thumbnail);
        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int id=album.getId();
                String title=album.getTitle();
                int price =album.getPrice();
                int qty=album.getQuantity();

                Cart cart=new Cart(title,price,qty);
                cart.setId(id);

                cartViewModel1.delete(cart);
            }
        });

        holder.minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int id = album.getId();
                String title = album.getTitle();
                int price = album.getPrice();
                int qty = album.getQuantity();
                if (qty <= 1)
                    qty = 2;

                Cart cart = new Cart(title, price, --qty);
                cart.setId(id);
                cartViewModel1.update(cart);
            }

        });
        holder.plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int id=album.getId();
                String title=album.getTitle();
                int price =album.getPrice();
                int qty=album.getQuantity();
                if (qty >= 10)
                    qty = 9;

                Cart cart=new Cart(title,price,++qty);
                cart.setId(id);
                cartViewModel1.update(cart);
            }
        });
    }

    @Override
    public int getItemCount() {
        return cartList.size();
    }
    public void setCart(List<Cart> cart)
    {
        this.cartList=cart;
        notifyDataSetChanged();
    }
}