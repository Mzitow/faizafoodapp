package com.mzitow.foodsandcosmeticjungle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.mzitow.foodsandcosmeticjungle.adabters.AddProductAdapter;
import com.mzitow.foodsandcosmeticjungle.database.ProductEntity;
import com.mzitow.foodsandcosmeticjungle.database.UserDatabase;

import java.util.List;

public class ProductHistory extends AppCompatActivity {
    TextView tvInfo;
    RecyclerView producerHistoryR;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_history);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("producer Products");

        tvInfo = findViewById(R.id.producer_producer_info_tv);
        producerHistoryR = findViewById(R.id.producer_order_history_recycler);




        UserDatabase userDatabase = UserDatabase.getUserDatabase(getApplicationContext());
        List<ProductEntity> productEntityList= userDatabase.productsDao().getAllProductsList();

        if (productEntityList.isEmpty()){
            tvInfo.setVisibility(View.VISIBLE);

        }else{
            tvInfo.setVisibility(View.INVISIBLE);
            producerHistoryR.setLayoutManager(new LinearLayoutManager(this));
            AddProductAdapter addProductAdapter= new AddProductAdapter(productEntityList,getApplicationContext());
            producerHistoryR.setAdapter(addProductAdapter);


        }




    }
}