package com.mzitow.foodsandcosmeticjungle.adabters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mzitow.foodsandcosmeticjungle.ProductCosmeticDiscription;
import com.mzitow.foodsandcosmeticjungle.ProductDiscription;
import com.mzitow.foodsandcosmeticjungle.R;
import com.mzitow.foodsandcosmeticjungle.database.ProductEntity;

import java.util.List;

public class AddProductAdapter extends RecyclerView.Adapter<AddProductAdapter.ViewHolder> {
    List<ProductEntity> productsList;
    Context cont;

    public AddProductAdapter(List<ProductEntity> productsList, Context cons) {
        this.productsList = productsList;
        this.cont = cons;


    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.new_product_card_view, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.productName.setText(productsList.get(position).getProductName());
        holder.productDescription.setText(productsList.get(position).getProductDescription());
        holder.productPrice.setText(productsList.get(position).getProductPrice());

        holder.detl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(cont, ProductCosmeticDiscription.class);
                intent.putExtra("name", productsList.get(position).getProductName() );
                intent.putExtra("description", productsList.get(position).getProductDescription() );
                intent.putExtra("price", productsList.get(position).getProductPrice() );
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                cont.startActivity(new Intent(intent));

            }
        });





    }

    @Override
    public int getItemCount() {
        return productsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView productName, productDescription,productPrice , cosDetailProducts;
        public Button accept,decline;
        public ImageView detl;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            productName = itemView.findViewById(R.id.txtProductName);
            productDescription = itemView.findViewById(R.id.txtProductDiscription);
            productPrice = itemView.findViewById(R.id.txtProductPrice);
            detl = itemView.findViewById(R.id.imgmore);


        }
    }
}
