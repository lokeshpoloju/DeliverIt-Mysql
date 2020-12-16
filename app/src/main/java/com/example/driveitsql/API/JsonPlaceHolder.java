package com.example.driveitsql.API;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface JsonPlaceHolder {

     @FormUrlEncoded
        @POST("/orders/")
            Call<ResponseBody> setOrder(@Field("driverid") int driverid, @Field("name") String name ,@Field("orderid") int orderid, @Field("time") int time);

    @FormUrlEncoded
        @POST("/customer/")
             Call<String> getOrderDetails(@Field("orderid") int orderid);

    @FormUrlEncoded
        @POST("/driver/")
            Call<String> getDriverDetails(@Field("driverid") int driverid);

}

