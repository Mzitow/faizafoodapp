package com.mzitow.foodsandcosmeticjungle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import com.mzitow.foodsandcosmeticjungle.database.FoodProductDao;
import com.mzitow.foodsandcosmeticjungle.database.FoodProductEntity;
import com.mzitow.foodsandcosmeticjungle.database.ProductEntity;
import com.mzitow.foodsandcosmeticjungle.database.ProductsDao;
import com.mzitow.foodsandcosmeticjungle.database.UserDao;
import com.mzitow.foodsandcosmeticjungle.database.UserDatabase;
import com.mzitow.foodsandcosmeticjungle.database.UserEntity;

public class AddProduct extends AppCompatActivity {
    EditText productName, productPrice, productDiscription;
    Button submit, submitAsfood;
    SwitchCompat switchCompat;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Add Products");




        productName = findViewById(R.id.et_productname);
        productPrice = findViewById(R.id.et_productprice);
        productDiscription = findViewById(R.id.et_productdescrition);
        submit = findViewById(R.id.button_addproduct);
        switchCompat = findViewById(R.id.switch_button_food);
        submitAsfood = findViewById(R.id.button_addfoodt);

        submit.setVisibility(View.INVISIBLE);

        switchCompat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked){
                    submitAsfood.setVisibility(View.INVISIBLE);
                    submit.setVisibility(View.VISIBLE);
                }else {

                    submitAsfood.setVisibility(View.VISIBLE);
                    submit.setVisibility(View.INVISIBLE);




                }
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ProductEntity productEntity = new ProductEntity();
                productEntity.setProductName(productName.getText().toString());
                productEntity.setProductDescription(productDiscription.getText().toString());
                productEntity.setProductPrice(productPrice.getText().toString());

                if (validateInput(productEntity)){

                    UserDatabase userDatabase = UserDatabase.getUserDatabase(getApplicationContext());
                    ProductsDao productsDao = userDatabase.productsDao();



                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            productsDao.addproduct(productEntity);
//                            Toast toast = Toast.makeText(getApplicationContext(), "submitted successful", Toast.LENGTH_SHORT);
//                            toast.show();
                            Intent intent = new Intent(getApplicationContext(), ProducerDashboard.class);
                            startActivity(intent);



                        }
                    }).start();;

                }else{
                    Toast toast = Toast.makeText(getApplicationContext(), "fill all the fields", Toast.LENGTH_SHORT);
                    toast.show();

                }
            }
        });




        submitAsfood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FoodProductEntity foodProductEntity = new FoodProductEntity();
                foodProductEntity.setProductName(productName.getText().toString());
                foodProductEntity.setProductDescription(productDiscription.getText().toString());
                foodProductEntity.setProductPrice(productPrice.getText().toString());

                if (validateFoodInput(foodProductEntity)){

                    UserDatabase userDatabase = UserDatabase.getUserDatabase(getApplicationContext());
                    FoodProductDao foodProductDao = userDatabase.foodProductDao();



                    new Thread(new Runnable() {
                        @Override
                        public void run() {

                            foodProductDao.addFoodProduct(foodProductEntity);
//                            Toast toast = Toast.makeText(getApplicationContext(), "submitted successful", Toast.LENGTH_SHORT);
//                            toast.show();
                            Intent intent = new Intent(getApplicationContext(), ProducerDashboard.class);
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
    private  boolean validateInput(ProductEntity productEntity){
        if ( productEntity.getProductName().isEmpty() || productEntity.getProductDescription().isEmpty()  || productEntity.getProductPrice().isEmpty()  ){
            return false;
        }

        return true;

    }
    private  boolean validateFoodInput(FoodProductEntity productEntity){
        if ( productEntity.getProductName().isEmpty() || productEntity.getProductDescription().isEmpty()  || productEntity.getProductPrice().isEmpty()  ){
            return false;
        }

        return true;

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.nav_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.nav_home:
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
                return true;
            case R.id.nav_products:
                startActivity(new Intent(getApplicationContext(),ProducerDashboard.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }

    }

//    @Override
//    public boolean onSupportNavigateUp() {
//        onBackPressed();
//        return true;
//    }

    @Override
    public void onBackPressed() {
          finish();
        super.onBackPressed();
    }
}