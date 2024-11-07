package com.example.user.globalnewsapp.local_db.database;


import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.example.user.globalnewsapp.local_db.dao.NewsDao;
import com.example.user.globalnewsapp.data.vo.Enclosure;
import com.example.user.globalnewsapp.data.vo.Items;
import com.example.user.globalnewsapp.data.vo.News;
import com.example.user.globalnewsapp.local_db.entity.EnclosureTable;
import com.example.user.globalnewsapp.local_db.entity.ItemsTable;

@Database(entities = {ItemsTable.class,EnclosureTable.class},version = 1,exportSchema = false)
public abstract class NewsDB extends RoomDatabase {
    private static NewsDB Ins;

    public abstract NewsDao getDao();

    public static NewsDB getIns(Context ctxt){
        if(Ins==null){
            Ins=Room.databaseBuilder(ctxt,NewsDB.class,"news.db")
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return Ins;
    }
}
