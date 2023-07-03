package com.example.demopropertyfacilityjava.retrofit;

import com.example.demopropertyfacilityjava.models.PropertyResponseModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("db")
    Call<PropertyResponseModel> getProperties();
}