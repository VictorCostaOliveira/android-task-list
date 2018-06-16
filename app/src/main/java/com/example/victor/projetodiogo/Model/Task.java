package com.example.victor.projetodiogo.Model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by victor on 13/06/18.
 */

@Entity
public class Task {
    @PrimaryKey(autoGenerate = true)
    private int uid;

    @ColumnInfo(name = "description")
    private String description;

    @ColumnInfo(name = "status")
    private Boolean done;

    public Task(String description) {
        this.description = description;
        this.done = false;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getDone() {
        return done;
    }

    public void setDone(Boolean done) {
        this.done = done;
    }
}
