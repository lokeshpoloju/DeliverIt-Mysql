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

public class Driver extends AppCompatActivity {

    TextView txt1;
    EditText etDriver;
    Button btndrv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver);

        txt1=findViewById(R.id.txt1);
        etDriver=findViewById(R.id.etDriver);
        btndrv=findViewById(R.id.btndrv);


        btndrv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDriver();
            }
        });
    }

    public void getDriver(){
        int driverid= Integer.parseInt(etDriver.getText().toString());

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.0.0.27:3007")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JsonPlaceHolder jsonPlaceHolder = retrofit.create(JsonPlaceHolder.class);
        Call<String> call = jsonPlaceHolder.getDriverDetails(driverid);
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if(!response.isSuccessful()){
                    txt1.setText("code " +response.body());
                    return;
                }
                txt1.setText(response.body());

            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                txt1.setText(t.getMessage());

            }
        });

    }

}