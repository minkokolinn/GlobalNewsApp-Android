package com.example.user.globalnewsapp.local_db.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.user.globalnewsapp.data.vo.MyItem;
import com.example.user.globalnewsapp.data.vo.News;
import com.example.user.globalnewsapp.local_db.entity.EnclosureTable;
import com.example.user.globalnewsapp.local_db.entity.ItemsTable;

import java.util.List;

@Dao
public interface NewsDao {
    @Insert
    void insertItem(ItemsTable items);

    @Query("Select * from ItemsTable left join EnclosureTable on ItemsTable.enclosure_id=EnclosureTable.id")
    LiveData<List<MyItem>> getNews();

    @Insert
    long insertEnclosure(EnclosureTable enclosure);

    @Query("delete from EnclosureTable")
    void deleteEnclosure();

    @Query("delete from ItemsTable")
    void deleteItem();
}
