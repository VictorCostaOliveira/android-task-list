package com.example.victor.projetodiogo.utils.interfaces;

import com.example.victor.projetodiogo.Model.Task;

import java.util.List;

/**
 * Created by victor on 17/06/18.
 */

public interface DBOperationsTaskCallBack {
    void taskSaved(Boolean success);

    void getAllTasks(List<Task> listaTarefas);
}
