package com.example.victor.projetodiogo.utils;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.example.victor.projetodiogo.DAO.TaskDao;
import com.example.victor.projetodiogo.DAO.TaskListDao;
import com.example.victor.projetodiogo.DAO.UserDao;
import com.example.victor.projetodiogo.Model.Task;
import com.example.victor.projetodiogo.Model.TaskList;
import com.example.victor.projetodiogo.Model.User;

import java.util.List;

/**
 * Created by victor on 13/06/18.
 */

public class DbOperations {
    private static final String TAG = DbOperations.class.getName();

    private Context context;
    private DBOperationsCallBack callback;
    private DBOperationsTaskCallBack taskCallback;
    private DBOperationTaskListCallBack taskListCallback;

    public DbOperations(Context context) {
        this.context = context;
    }

    public void saveUser(User user, DBOperationsCallBack callback){
        this.callback = callback;
        new saveUser().execute(user);
    }

    public void saveTaskList(TaskList taskList, DBOperationTaskListCallBack callback){
        this.callback = callback;
        new saveUserTaskLlist().execute(taskList);
    }

    public void saveTask(Task task, DBOperationsTaskCallBack callback){
        this.taskCallback = callback;
        new saveTaskTask().execute(task);
    }

    public void getAllTasks(DBOperationsTaskCallBack callBack){
        this.taskCallback = callBack;
        new getAllTasksTask().execute();
    }

    public void queryAuthenticatedUser(String user, String pass, DBOperationsCallBack callback){
        this.callback = callback;
        new findUser().execute(user, pass);
    }

    private class saveUser extends AsyncTask<User, Void, Void> {
        @Override
        protected Void doInBackground(User... users) {
            try {
                UserDao userDao = AppDatabase.getInstance(context).userDao();
                userDao.insertAll(users);
                if (callback != null) {
                    callback.savedUser(true);
                }
            } catch (Exception e) {
                Log.e("saveUserTask", e.getMessage());
                if (callback != null) {
                    callback.savedUser(false);
                }
            }
            return null;
        }
    }

    private class saveUserTaskLlist extends AsyncTask<TaskList, void, void> {
        @Override
        protected void doInBackground(TaskList... taskLists) {
            try {
                TaskListDao taskListDao = AppDatabase.getInstance(context).taskListDao();
                taskListDao.insertAll(taskLists);
                if (callback != null) {
                    callback.
                }
            } catch (Exception e) {

            }
        }
    }

    private class saveTaskTask extends AsyncTask<Task, Void, Void> {
        @Override
        protected Void doInBackground(Task... tasks) {
            try {
                TaskDao taskDao = AppDatabase.getInstance(context).taskDao();
                taskDao.insertTasks(tasks);
                if (taskCallback != null) {
                    taskCallback.taskSaved(true);
                }
            } catch (Exception e) {
                Log.e("saveTaskTask", e.getMessage());
                if (taskCallback!= null) {
                    taskCallback.taskSaved(false);
                }
            }
            return null;
        }
    }

    private class findUser extends AsyncTask<String, Void, Void> {
        @Override
        protected Void doInBackground(String... params) {
            try {
                UserDao userDao = AppDatabase.getInstance(context).userDao();
                User user = userDao.findAuthenticatedUser(params[0], params[1]);
                if (callback != null) {
                    callback.userExists(user != null, user);
                }
            } catch (Exception e) {
                Log.e("queryUser", e.getMessage());
                if (callback != null) {
                    callback.userExists(false, null);
                }
            }
            return null;
        }
    }

    private class getAllTasksTask extends AsyncTask<Void, Void, Void> {
        @Override
        protected Void doInBackground(Void... params) {
            try {
                List<Task> lista = AppDatabase.getInstance(context).taskDao().getAll();
                if(taskCallback != null) {
                    taskCallback.getAllTasks(lista);
                }
            } catch (Exception e) {
                Log.e("queryUser", e.getMessage());
            }
            return null;
        }
    }

}
