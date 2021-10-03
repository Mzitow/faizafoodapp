package com.mzitow.foodsandcosmeticjungle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ProducerLogin extends AppCompatActivity {

    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_producer_login);

        login = findViewById(R.id.button_signin);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProducerLogin.this, ProducerDashboard.class);
                startActivity(intent);

                Toast toast = Toast.makeText(ProducerLogin.this, "signup succces", Toast.LENGTH_SHORT);
                toast.show();
            }
        });

    }
}
