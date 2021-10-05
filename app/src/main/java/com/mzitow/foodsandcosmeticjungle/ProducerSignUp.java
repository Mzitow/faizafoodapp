package com.mzitow.foodsandcosmeticjungle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ProducerSignUp extends AppCompatActivity {
    EditText producerEmail, producerName, producerPass,producerPhone;

    Button signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_producer_sign_up);

        producerEmail = findViewById(R.id.et_produceremail);
        producerName = findViewById(R.id.et_producerusername);
        producerPass = findViewById(R.id.et_producerpassword);
        producerPhone = findViewById(R.id.et_produceremail);


        signup = findViewById(R.id.button_producersignup);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(ProducerSignUp.this, ProducerLogin.class);
//                startActivity(intent);
//
//                Toast toast = Toast.makeText(ProducerSignUp.this, "signup succces", Toast.LENGTH_SHORT);
//                toast.show();

                UserEntity userEntity = new UserEntity();
                userEntity.setName(producerName.getText().toString());
                userEntity.setPassword(producerPass.getText().toString());
                userEntity.setEmail(producerEmail.getText().toString());
                userEntity.setPhone(producerPhone.getText().toString());

                if (validateInput(userEntity)){

                    UserDatabase userDatabase = UserDatabase.getUserDatabase(getApplicationContext());
                    UserDao userDao =userDatabase.userDao();

                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            userDao.registerUser(userEntity);
                            Toast toast = Toast.makeText(getApplicationContext(), "User Register successful", Toast.LENGTH_SHORT);
                            toast.show();
                            Intent intent = new Intent(getApplicationContext(), ProducerLogin.class);
                            startActivity(intent);


                        }
                    }).start();;

                }else{
                    Toast toast = Toast.makeText(getApplicationContext(), "fill all the fields", Toast.LENGTH_SHORT);
                    toast.show();

                }
            }
        });
    }
    private  boolean validateInput(UserEntity userEntity){
        if ( userEntity.getName().isEmpty() || userEntity.getPassword().isEmpty() || userEntity.getEmail().isEmpty() ||userEntity.getPhone().isEmpty() ){
            return false;
        }

        return true;

    }
}