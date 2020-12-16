package com.example.driveitsql;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

       Button buttonAdmin;
       Button buttonDriver;
       Button buttonCustomer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonAdmin = findViewById(R.id.buttonAdmin);
        buttonCustomer = findViewById(R.id.buttonCustomer);
        buttonDriver = findViewById(R.id.buttonDriver);
        buttonAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveToAdmin();
            }
        });


        buttonDriver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveToDriver();
            }
        });
        buttonCustomer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveToCustomer();
            }
        });

    }
    public void moveToAdmin(){
        Intent i=new Intent(MainActivity.this,Admin.class);
        startActivity(i);
    }
    public void moveToDriver(){
        Intent i1= new Intent(MainActivity.this,Driver.class);
        startActivity(i1);
    }

    public void moveToCustomer(){
        Intent i2=new Intent(MainActivity.this,Customer.class);
        startActivity(i2);
    }
}