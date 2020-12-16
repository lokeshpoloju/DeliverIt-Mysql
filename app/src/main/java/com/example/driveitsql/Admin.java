package com.example.driveitsql;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.driveitsql.API.JsonPlaceHolder;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class Admin extends AppCompatActivity {
    EditText et1;
    EditText et2;
    EditText et3;
    EditText et4;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        btn = findViewById(R.id.btn);
        et1 = findViewById(R.id.et1);
        et2 = findViewById(R.id.et2);
        et3 = findViewById(R.id.et3);
        et4 = findViewById(R.id.et4);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = et1.getText().toString();
                int orderid = Integer.parseInt(et2.getText().toString());
                int time = Integer.parseInt(et3.getText().toString());
                int driverid = Integer.parseInt(et4.getText().toString());
             addData(driverid,name,orderid,time);
            }
        });

    }

    public void addData( int driverid,String name, int orderid, int time) {
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("http://10.0.0.27:3007")
                .build();
        JsonPlaceHolder jsonPlaceHolder=retrofit.create(JsonPlaceHolder.class);

        Call<ResponseBody> call= jsonPlaceHolder.setOrder(driverid,name,orderid,time);

        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if(!response.isSuccessful()){
                    Toast.makeText(Admin.this,"Failed",Toast.LENGTH_LONG).show();
                }
            Toast.makeText(Admin.this,"Success",Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(Admin.this, t.toString(),Toast.LENGTH_LONG).show();

            }
        });

    }
}