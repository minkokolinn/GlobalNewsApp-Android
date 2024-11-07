package com.example.user.globalnewsapp.data.models;

import com.example.user.globalnewsapp.networks.ApiService;
import com.example.user.globalnewsapp.utils.AppConstant;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BaseModel {
    protected ApiService api;

    public BaseModel(){
        Retrofit retrofit=new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(AppConstant.BASE_URL)
                .build();
        api=retrofit.create(ApiService.class);
    }
}
