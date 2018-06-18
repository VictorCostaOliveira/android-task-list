package com.example.victor.projetodiogo.DAO;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.victor.projetodiogo.Model.TaskList;

import java.util.List;

/**
 * Created by victor on 16/06/18.
 */
@Dao
public interface TaskListDao {
    @Insert()
    void insertAll(TaskList... tasklists);

    @Update
    void update(TaskList... taskLists);

    @Delete
    void delete(TaskList... taskLists);

    @Query("SELECT * FROM taskList WHERE userId=:userId")
    List<TaskList> userTaskLists(final int userId);
}
