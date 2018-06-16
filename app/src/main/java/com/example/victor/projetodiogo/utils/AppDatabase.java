package com.example.victor.projetodiogo.utils;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.example.victor.projetodiogo.DAO.TaskDao;
import com.example.victor.projetodiogo.DAO.TaskListDao;
import com.example.victor.projetodiogo.DAO.UserDao;
import com.example.victor.projetodiogo.Model.Task;
import com.example.victor.projetodiogo.Model.TaskList;
import com.example.victor.projetodiogo.Model.User;

/**
 * Created by victor on 13/06/18.
 */
@Database(entities = {User.class, Task.class, TaskList.class}, version=1)
public abstract class AppDatabase extends RoomDatabase {
    private static final String databaseName = "projeto_diogo";

    private static AppDatabase instance;

    public abstract UserDao userDao();
    public abstract TaskDao taskDao();
    public abstract TaskListDao taskListDao();

    public static AppDatabase getInstance(Context context) {
        if (instance == null || !instance.isOpen()) {
            instance = Room.databaseBuilder(context, AppDatabase.class, databaseName)
                    .build();
        }
        return instance;
    }
}
