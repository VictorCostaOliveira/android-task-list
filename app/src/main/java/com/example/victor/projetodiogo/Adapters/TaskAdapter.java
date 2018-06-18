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

import com.example.victor.projetodiogo.Model.Task;
import com.example.victor.projetodiogo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by victor on 15/06/18.
 */

public class TaskAdapter extends ArrayAdapter<Task> {
    ArrayList<Task> tasks;
    public TaskAdapter(@NonNull Context context, int resource, @NonNull List<Task> objects) {
        super(context, resource);
        tasks = new ArrayList<>(objects.size());
        tasks.addAll(objects);
    }

    @Nullable
    @Override
    public Task getItem(int position) {
        return tasks.get(position);
    }

    @Override
    public int getCount() {
        return tasks.size();
    }

    @Override
    public void add(@Nullable Task object) {
        tasks.add(object);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) this.getContext()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemTarefa = inflater.inflate(R.layout.task_item, parent,false);

        Task task = getItem(position);
        TextView titulo = (TextView) itemTarefa.findViewById(R.id.task_name_view);
        titulo.setText(task.getDescription());
        CheckBox status = (CheckBox) itemTarefa.findViewById(R.id.status);
        status.setChecked(task.getDone());

        return itemTarefa;
    }


}