package com.mzitow.foodsandcosmeticjungle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ConsumerSignUp extends AppCompatActivity {
    EditText email, username,password,phone;
    Button signup;
    DBHelper Db;
    public static final String MY_PREFS_NAME = "MyPrefsFile";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consumer_sign_up);


        email= findViewById(R.id.et_email);
        username= findViewById(R.id.et_username);
        password= findViewById(R.id.et_password);
        phone= findViewById(R.id.et_phone);
        email= findViewById(R.id.et_email);
        signup= findViewById(R.id.button_signup);

        String name = username.getText().toString().trim();
        String pass = password.getText().toString().trim();

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                Db.insertcustomerdata(name,pass);





                SharedPreferences sharedPreferences = getSharedPreferences("consumerSignup", Context.MODE_PRIVATE);
                SharedPreferences.Editor preferencesEditor = sharedPreferences.edit();
                preferencesEditor.putString("Name", name);
                preferencesEditor.putString("password", pass);
                preferencesEditor.apply();


                Intent intent = new Intent(ConsumerSignUp.this, CustomerLogin.class);
                startActivity(intent);
                Toast toast = Toast.makeText(ConsumerSignUp.this, "signup succces", Toast.LENGTH_SHORT);
                toast.show();
            }
        });



    }
}