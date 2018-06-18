package com.example.victor.projetodiogo.Model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

import static android.arch.persistence.room.ForeignKey.CASCADE;

/**
 * Created by victor on 13/06/18.
 */

@Entity(foreignKeys = @ForeignKey(entity = TaskList.class, parentColumns = "uid", childColumns = "taskListId", onDelete = CASCADE))
public class Task {
    @PrimaryKey(autoGenerate = true)
    private int uid;
tat
    @ColumnInfo(name = "description")
    private String description;

    @ColumnInfo(name = "status")
    private Boolean done;

    @ColumnInfo(name = "taskListId")
    private int taskListId;

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

    public int getTaskListId() {
        return taskListId;
    }

    public void setTaskListId(int taskListId) {
        this.taskListId = taskListId;
    }
}
