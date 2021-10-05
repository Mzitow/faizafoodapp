package com.mzitow.foodsandcosmeticjungle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ProducerDashboard extends AppCompatActivity {

    CardView viewmyproducts, addprod;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_producer_dashboard);
        addprod = findViewById(R.id.addnewproducts);
        viewmyproducts = findViewById(R.id.myproducts);

        addprod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), AddProduct.class);
                startActivity(intent);

            }
        });
        viewmyproducts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), ProductHistory.class);
                startActivity(intent);


            }
        });


    }
}