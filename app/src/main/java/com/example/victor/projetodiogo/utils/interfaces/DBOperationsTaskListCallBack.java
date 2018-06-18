package com.example.victor.projetodiogo.utils.interfaces;

import com.example.victor.projetodiogo.Model.TaskList;

import java.util.List;

/**
 * Created by victor on 17/06/18.
 */

public interface DBOperationsTaskListCallBack {
    void taskListSaved(Boolean success);

    void getAllTaskLists(List<TaskList> taskLists);
}
