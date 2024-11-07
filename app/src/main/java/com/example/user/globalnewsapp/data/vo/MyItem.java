package com.example.user.globalnewsapp.data.vo;

import android.arch.persistence.room.Ignore;

import com.example.user.globalnewsapp.local_db.entity.ItemsTable;

public class MyItem extends ItemsTable{
    private String imgLink;

    public MyItem(String title, String description, long enclosure_id, String img_link) {
        super(title, description, enclosure_id);
        this.imgLink = img_link;
    }
    @Ignore
    public MyItem(String img_link) {
        this.imgLink = img_link;
    }

    public MyItem(){

    }



    public String getImgLink() {
        return imgLink;
    }

    public void setImgLink(String imgLink) {
        this.imgLink = imgLink;
    }
}
