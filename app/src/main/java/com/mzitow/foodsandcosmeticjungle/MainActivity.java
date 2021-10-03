package com.mzitow.foodsandcosmeticjungle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button consumer, producer, delivery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        consumer = findViewById(R.id.button_consumer);
        producer = findViewById(R.id.button_producer);
        delivery = findViewById(R.id.button_delivery);

        consumer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent consume = new Intent(MainActivity.this, CustomerLogin.class);
                startActivity(consume);
            }
        });
        producer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent consume = new Intent(MainActivity.this, ProducerLogin.class);
                startActivity(consume);
            }
        });
        delivery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent consume = new Intent(MainActivity.this, DeliveryLogin.class);
                startActivity(consume);
            }
        });


    }
}