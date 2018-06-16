package com.example.victor.projetodiogo.Model;

import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Relation;

import java.util.List;

/**
 * Created by victor on 16/06/18.
 */

public class TaskListWithTask {
    @Embedded
    public User user;

    @Relation(parentColumn = "id", entityColumn = "taskListId", entity = Task.class)
    public List<Task> tasks;
}
