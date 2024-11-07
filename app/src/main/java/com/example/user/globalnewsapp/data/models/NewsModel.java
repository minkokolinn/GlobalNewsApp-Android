package com.example.user.globalnewsapp.data.models;

import com.example.user.globalnewsapp.data.vo.News;
import com.example.user.globalnewsapp.delegate.NewsDelegate;
import com.example.user.globalnewsapp.utils.AppConstant;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewsModel extends BaseModel{
    public NewsModel(){
        super();
    }

    public void getNews(final NewsDelegate delegate){
        api.getNews(AppConstant.URL_LINK).enqueue(new Callback<News>() {
            @Override
            public void onResponse(Call<News> call, Response<News> response) {
                delegate.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<News> call, Throwable t) {
                delegate.onError(t.getMessage());
            }
        });
    }
}
