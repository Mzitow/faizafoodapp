package com.mzitow.foodsandcosmeticjungle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.mzitow.foodsandcosmeticjungle.adabters.AddProductAdapter;
import com.mzitow.foodsandcosmeticjungle.adabters.DeliveryInfoAdapter;
import com.mzitow.foodsandcosmeticjungle.database.FoodProductEntity;
import com.mzitow.foodsandcosmeticjungle.database.ProductEntity;
import com.mzitow.foodsandcosmeticjungle.database.UserDatabase;
import com.mzitow.foodsandcosmeticjungle.model.CustomModel;
import com.mzitow.foodsandcosmeticjungle.model.Model;

import java.util.ArrayList;
import java.util.List;

public class ProductHistory extends AppCompatActivity implements DeliveryInfoAdapter.OnDeleteListener {
    TextView tvInfo;
    RecyclerView producerHistoryR;
    CustomModel customModel = new CustomModel(this);
    ArrayList<Model> list;
    private DatabaseReference root = FirebaseDatabase.getInstance().getReference("images");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_history);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("producer Products");

        tvInfo = findViewById(R.id.producer_producer_info_tv);
        producerHistoryR = findViewById(R.id.producer_order_history_recycler);


        UserDatabase userDatabase = UserDatabase.getUserDatabase(getApplicationContext());
        List<ProductEntity> productEntityList = userDatabase.productsDao().getAllProductsList();
        List<FoodProductEntity> foodProductEntityList = userDatabase.foodProductDao().getAllProductsList();

        if (productEntityList.isEmpty()) {
            tvInfo.setVisibility(View.VISIBLE);

        } else {
            tvInfo.setVisibility(View.INVISIBLE);
            producerHistoryR.setLayoutManager(new LinearLayoutManager(this));
            DeliveryInfoAdapter addProductAdapter = new DeliveryInfoAdapter(productEntityList, this, getApplicationContext(), list);
            producerHistoryR.setAdapter(addProductAdapter);

            root.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                        Model model = dataSnapshot.getValue(Model.class);
                        list.add(model);
                    }
                    addProductAdapter.notifyDataSetChanged();
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }


            });


        }

    }

    @Override
    public void OnDeletelistener (ProductEntity productEntity){

        customModel.delete(productEntity);

    }
}