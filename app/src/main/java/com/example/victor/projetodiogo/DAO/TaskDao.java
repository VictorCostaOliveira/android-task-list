package com.example.victor.projetodiogo.DAO;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.victor.projetodiogo.Model.Task;

import java.util.List;

/**
 * Created by victor on 13/06/18.
 */
@Dao
public interface TaskDao {
    @Query("SELECT * FROM task")
    List<Task> getAll();

    @Insert
    void insertTasks(Task... tasks);

    @Delete
    void delete(Task task);
}
