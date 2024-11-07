package com.example.user.globalnewsapp.view_model;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;
import android.util.Log;

import com.example.user.globalnewsapp.data.models.NewsModel;
import com.example.user.globalnewsapp.data.vo.Enclosure;
import com.example.user.globalnewsapp.data.vo.Items;
import com.example.user.globalnewsapp.data.vo.MyItem;
import com.example.user.globalnewsapp.local_db.database.NewsDB;
import com.example.user.globalnewsapp.data.vo.News;
import com.example.user.globalnewsapp.delegate.NewsDelegate;
import com.example.user.globalnewsapp.local_db.entity.EnclosureTable;
import com.example.user.globalnewsapp.local_db.entity.ItemsTable;

import java.util.ArrayList;
import java.util.List;

public class NewsViewModel extends AndroidViewModel {
    MutableLiveData<News> liveData=new MutableLiveData<>();
    NewsDB db;
    public NewsViewModel(@NonNull Application application) {
        super(application);
        db=NewsDB.getIns(application);
        loadData();
    }


    public void loadData(){
        NewsModel nm=new NewsModel();
        nm.getNews(new NewsDelegate() {
            @Override
            public void onSuccess(News news) {
                db.getDao().deleteEnclosure();
                db.getDao().deleteItem();
                ArrayList<Items> items= (ArrayList<Items>) news.getItems();
                for (Items i:items){
                    Enclosure en=i.getEnclosure();

                    EnclosureTable enclosureTable=new EnclosureTable(en.getLink());

                    long id=db.getDao().insertEnclosure(enclosureTable);

                    ItemsTable itemsTable=new ItemsTable(i.getTitle(),i.getDescription(),id);
                    db.getDao().insertItem(itemsTable);
                }
            }

            @Override
            public void onError(String str) {
                Log.d("hello",str);
            }
        });
    }

    public LiveData<List<MyItem>> getNews(){
        return db.getDao().getNews();
    }

}
