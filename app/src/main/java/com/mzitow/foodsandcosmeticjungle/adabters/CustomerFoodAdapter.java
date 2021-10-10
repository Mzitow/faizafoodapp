package com.mzitow.foodsandcosmeticjungle.adabters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mzitow.foodsandcosmeticjungle.ProductDiscription;
import com.mzitow.foodsandcosmeticjungle.R;
import com.mzitow.foodsandcosmeticjungle.database.FoodProductEntity;

import java.util.List;

public class CustomerFoodAdapter extends RecyclerView.Adapter<CustomerFoodAdapter.ViewHolder> {

    public FoodProductEntity foodProductEntity;
    public Context fcontext;

    public CustomerFoodAdapter(List<FoodProductEntity> foodProductEntities, Context c) {
        this.foodProductEntities = foodProductEntities;
        this.fcontext = c;
    }

    List<FoodProductEntity> foodProductEntities;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.food_card, parent, false);

        return new CustomerFoodAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.productName.setText(foodProductEntities.get(position).getProductName());
        holder.productDescription.setText(foodProductEntities.get(position).getProductDescription());
        holder.productPrice.setText(foodProductEntities.get(position).getProductPrice());

        holder.detailProducts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(fcontext, ProductDiscription.class);
                intent.putExtra("name", foodProductEntities.get(position).getProductName() );
                intent.putExtra("description", foodProductEntities.get(position).getProductDescription() );
                intent.putExtra("price", foodProductEntities.get(position).getProductPrice() );
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                fcontext.startActivity(new Intent(intent));

            }
        });



    }

    @Override
    public int getItemCount() {
        return foodProductEntities.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView productName, productDescription,productPrice ,detailProducts;

       // public Button accept,decline;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            productName = itemView.findViewById(R.id.foodproduct_item_name);
            productDescription = itemView.findViewById(R.id.fooditem_short_desc);
            productPrice = itemView.findViewById(R.id.foodproduct_item_price);
            detailProducts = itemView.findViewById(R.id.tv_details_product);




        }
    }
}
