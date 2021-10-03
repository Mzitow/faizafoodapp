package com.mzitow.foodsandcosmeticjungle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CustomerLogin extends AppCompatActivity {
    EditText username, password;
    TextView register;
    Button signIn;
    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_login);

        username = findViewById(R.id.et_username);
        password = findViewById(R.id.et_password);
        signIn = findViewById(R.id.button_signin);
        register = findViewById(R.id.regeistertxt);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CustomerLogin.this, ConsumerSignUp.class);
                startActivity(intent);

            }
        });

        String Name = username.getText().toString().trim();
        String password = username.getText().toString().trim();

        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//              Cursor res= db.getdata();
//                StringBuffer buffer = new StringBuffer();
//                while(res.moveToNext()){
//                    buffer.append("Name :"+res.getString(0)+"\n");
//                    buffer.append("password :"+res.getString(1)+"\n");
//
//                }
                SharedPreferences sharedPreferences = getSharedPreferences("consumerSignup", Context.MODE_PRIVATE);
                String namers = sharedPreferences.getString("Name", "default");
                String passrs = sharedPreferences.getString("password", "default");


                if (passrs.equals(password)   ){
                    Intent intent = new Intent(CustomerLogin.this, ConsumerDashboard.class);
                    startActivity(intent);
                    Toast toast = Toast.makeText(CustomerLogin.this, "signup succces", Toast.LENGTH_SHORT);
                    toast.show();



                }
                else {
                    Toast toast = Toast.makeText(CustomerLogin.this, "please try again", Toast.LENGTH_SHORT);
                    toast.show();

                }



//

            }
        });

    }
}