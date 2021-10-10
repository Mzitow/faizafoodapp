package com.mzitow.foodsandcosmeticjungle.adabters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mzitow.foodsandcosmeticjungle.R;
import com.mzitow.foodsandcosmeticjungle.database.CartEnity;
import com.mzitow.foodsandcosmeticjungle.database.DeliveryDataEntity;

import java.util.List;

public class DeliveryCartAdapter extends RecyclerView.Adapter<DeliveryCartAdapter.ViewHolder> {
    List<DeliveryDataEntity> deliveryDataEntities ;

    public DeliveryCartAdapter(List<DeliveryDataEntity> deliveryDataEntities) {
        this.deliveryDataEntities = deliveryDataEntities;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.delivery_card, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.productDeliveryName.setText(deliveryDataEntities.get(position).getName());
        holder.productDeliveryLocation.setText(deliveryDataEntities.get(position).getLocation());
        holder.productDeliveryContact.setText(deliveryDataEntities.get(position).getPhoneNo());

    }

    @Override
    public int getItemCount() {
        return deliveryDataEntities.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView productDeliveryName, productDeliveryLocation, productDeliveryContact;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            productDeliveryName = itemView.findViewById(R.id.delivery_item_name);
            productDeliveryLocation = itemView.findViewById(R.id.delivery_location);
            productDeliveryContact = itemView.findViewById(R.id.delivery_item_phone);




        }
    }
}
