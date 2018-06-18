package com.example.victor.projetodiogo.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.victor.projetodiogo.Model.TaskList;
import com.example.victor.projetodiogo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by victor on 17/06/18.
 */

public class TaskListAdapter extends ArrayAdapter<TaskList> {
    ArrayList<TaskList> taskLists;
    public TaskListAdapter(@NonNull Context context, int resource, @NonNull List<TaskList> objects) {
        super(context, resource);
        taskLists = new ArrayList<>(objects.size());
        taskLists.addAll(objects);
    }

    @Nullable
    @Override
    public TaskList getItem(int position) {
        return taskLists.get(position);
    }

    @Override
    public int getCount() {
        return taskLists.size();
    }

    @Override
    public void add(@Nullable TaskList object) {
        taskLists.add(object);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) this.getContext()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View taskListItem = inflater.inflate(R.layout.task_list_item, null);

        TaskList taskList = getItem(position);
        TextView taskListName = (TextView) taskListItem.findViewById(R.id.task_name_view);
        taskListName.setText(taskList.getTaskListName());
//        CheckBox status = (CheckBox) itemTarefa.findViewById(R.id.status);
//        status.setChecked(tarefa.getDone());

        return taskListItem;
    }

}
