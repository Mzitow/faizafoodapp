package com.mzitow.foodsandcosmeticjungle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ConsumerDashboard extends AppCompatActivity {
    CardView food, cosmetics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consumer_dashboard);

        food = findViewById(R.id.foodcard);
        cosmetics = findViewById(R.id.cosmeticcard);

        food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ConsumerDashboard.this, ConsumerCategory.class);
                startActivity(intent);
            }
        });
        cosmetics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ConsumerDashboard.this, ConsumerCategory.class);
                startActivity(intent);
            }
        });

    }
}