package com.example.user.globalnewsapp.networks;

import com.example.user.globalnewsapp.data.vo.News;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    @GET("v1/api.json")
    Call<News> getNews(@Query("rss_url")String link);
}
