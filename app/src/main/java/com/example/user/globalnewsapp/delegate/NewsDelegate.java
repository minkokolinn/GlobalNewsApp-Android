package com.example.user.globalnewsapp.delegate;

import com.example.user.globalnewsapp.data.vo.News;

public interface NewsDelegate {
    void onSuccess(News news);
    void onError(String str);
}
