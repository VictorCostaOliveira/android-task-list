package com.example.victor.projetodiogo.DAO;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import com.example.victor.projetodiogo.Model.TaskListWithTask;

import java.util.List;

/**
 * Created by victor on 16/06/18.
 */
@Dao
public interface TaskListDao {
    @Query("SELECT * FROM TaskList")
    List<TaskListWithTask> tasks();
}
