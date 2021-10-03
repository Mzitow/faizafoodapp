package com.mzitow.foodsandcosmeticjungle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ProducerSignUp extends AppCompatActivity {
    Button signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_producer_sign_up);

        signup = findViewById(R.id.button_sign);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProducerSignUp.this, ProducerLogin.class);
                startActivity(intent);

                Toast toast = Toast.makeText(ProducerSignUp.this, "signup succces", Toast.LENGTH_SHORT);
                toast.show();
            }
        });
    }
}