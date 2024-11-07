package com.example.user.globalnewsapp.local_db.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class ItemsTable {
    @PrimaryKey(autoGenerate = true)
    private long id;
    private String title;
    private String description;
    private long enclosure_id;
    @Ignore

    public ItemsTable(String title, String description, long enclosure_id) {
        this.title = title;
        this.description = description;
        this.enclosure_id = enclosure_id;
    }
    public ItemsTable(){

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getEnclosure_id() {
        return enclosure_id;
    }

    public void setEnclosure_id(long enclosure_id) {
        this.enclosure_id = enclosure_id;
    }
}
