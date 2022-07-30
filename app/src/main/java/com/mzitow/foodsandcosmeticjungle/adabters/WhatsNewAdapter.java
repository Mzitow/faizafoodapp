package com.mzitow.foodsandcosmeticjungle.adabters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mzitow.foodsandcosmeticjungle.R;
import com.mzitow.foodsandcosmeticjungle.database.WhatsNewEntity;

import java.util.ArrayList;
import java.util.List;

public class WhatsNewAdapter extends RecyclerView.Adapter<WhatsNewAdapter.ViewHolder> {
    List<WhatsNewEntity> whatsNewEntities;

    public WhatsNewAdapter(List<WhatsNewEntity> whatsNewEntities) {
        this.whatsNewEntities = whatsNewEntities;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.product_card,parent,false);


        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.productName.setText(whatsNewEntities.get(position).getProductName());
        holder.productDescription.setText(whatsNewEntities.get(position).getProductDescription());
        holder.productPrice.setText(whatsNewEntities.get(position).getProductPrice());


    }

    @Override
    public int getItemCount() {
        return whatsNewEntities.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView productName, productDescription,productPrice;
        public Button accept,decline;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            productName = itemView.findViewById(R.id.product_item_name);
            productDescription = itemView.findViewById(R.id.item_short_desc);
            productPrice = itemView.findViewById(R.id.product_item_price);



        }
    }
}
