package com.example.user.globalnewsapp.local_db.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class EnclosureTable {
    @PrimaryKey(autoGenerate = true)
    private long id;
    private String imgLink;

    public EnclosureTable(String imgLink) {
        this.imgLink = imgLink;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getImgLink() {
        return imgLink;
    }

    public void setImgLink(String imgLink) {
        this.imgLink = imgLink;
    }
}
