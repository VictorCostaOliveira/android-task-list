package com.example.victor.projetodiogo.Model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

import static android.arch.persistence.room.ForeignKey.CASCADE;

/**
 * Created by victor on 16/06/18.
 */
@Entity(foreignKeys = @ForeignKey(entity = User.class, parentColumns = "uid", childColumns = "userId", onDelete = CASCADE))
public class TaskList {

    @PrimaryKey(autoGenerate = true)
    private int uid;

    @ColumnInfo(name = "taskListName")
    private String taskListName;

    @ColumnInfo(name = "userId")
    private int userId;

    public TaskList(String taskListName, int userId) {
        this.taskListName = taskListName;
        this.userId = userId;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getTaskListName() {
        return taskListName;
    }

    public void setTaskListName(String taskListName) {
        this.taskListName = taskListName;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
