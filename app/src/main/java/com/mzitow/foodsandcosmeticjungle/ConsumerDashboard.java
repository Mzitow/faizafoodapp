package com.mzitow.foodsandcosmeticjungle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toolbar;

public class ConsumerDashboard extends AppCompatActivity {
    CardView food, cosmetics;
    TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consumer_dashboard);

        food = findViewById(R.id.foodcard);
        cosmetics = findViewById(R.id.cosmeticcard);
        title = findViewById(R.id.consumercategory_title);
//        Toolbar toolbar = findViewById(R.id.toptool);
//
//       setActionBar(toolbar);
////
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        getSupportActionBar().setDisplayShowHomeEnabled(true);



//        String name = getIntent().getStringExtra("titleName");
//        title.setText(name);

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
//    @Override
//    public boolean onSupportNavigateUp() {
//        onBackPressed();
//        return true;

}