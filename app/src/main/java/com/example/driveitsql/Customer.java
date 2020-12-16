package com.example.driveitsql;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.driveitsql.API.JsonPlaceHolder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Customer extends AppCompatActivity {

       EditText etCtm;
       Button btnCtm;
       TextView getDriverTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer);

        etCtm = findViewById(R.id.etCtm);
        btnCtm = findViewById(R.id.btnCtm);
        getDriverTxt = findViewById(R.id.getDriverTxt);

        btnCtm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getData();
            }
        });
    }
    public void getData(){

        int orderid= Integer.parseInt(etCtm.getText().toString());

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.0.0.27:3007")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JsonPlaceHolder jsonPlaceHolder = retrofit.create(JsonPlaceHolder.class);
        Call<String> call = jsonPlaceHolder.getOrderDetails(orderid);
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if(!response.isSuccessful()){
                    getDriverTxt.setText("code " +response.body());
                    return;
                }
                getDriverTxt.setText(response.body());

            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                getDriverTxt.setText(t.getMessage());

            }
        });

    }
}