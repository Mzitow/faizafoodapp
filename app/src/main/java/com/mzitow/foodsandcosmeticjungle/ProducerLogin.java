package com.mzitow.foodsandcosmeticjungle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ProducerLogin extends AppCompatActivity {

    Button login;
    EditText producerlogName, producerlogpass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_producer_login);

        login = findViewById(R.id.button_signin);
        producerlogName = findViewById(R.id.et_producerlogusername);
        producerlogpass = findViewById(R.id.et_producerlogpassword);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(ProducerLogin.this, ProducerDashboard.class);
//                startActivity(intent);
//
//                Toast toast = Toast.makeText(ProducerLogin.this, "signup succces", Toast.LENGTH_SHORT);
//                toast.show();

                String user = producerlogName.getText().toString();
                String pass =  producerlogpass.getText().toString();

                if(user.isEmpty() || pass.isEmpty() ){

                    Toast toast = Toast.makeText(getApplicationContext(), "fill all the fields", Toast.LENGTH_SHORT);
                    toast.show();
                }else {
                    UserDatabase userDatabase = UserDatabase.getUserDatabase(getApplicationContext());
                    UserDao userDao = userDatabase.userDao();
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            UserEntity userEntity = userDao.login(user,pass);
                            if (userEntity == null){
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        Toast toast = Toast.makeText(getApplicationContext(), "invalid Credentials ", Toast.LENGTH_SHORT);
                                        toast.show();

                                    }
                                });

                            } else {
                                String titleName = userEntity.name;
                                Intent intent = new Intent(getApplicationContext(), ProducerDashboard.class)
                                        .putExtra("name",titleName);
                                startActivity(intent);


                            }


                        }
                    }).start();;
                }



            }
        });

    }
}
