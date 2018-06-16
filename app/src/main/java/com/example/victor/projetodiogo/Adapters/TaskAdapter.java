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
    ArrayList<Task> tarefas;
    public TaskAdapter(@NonNull Context context, int resource, @NonNull List<Task> objects) {
        super(context, resource);
        tarefas = new ArrayList<>(objects.size());
        tarefas.addAll(objects);
    }

    @Nullable
    @Override
    public Task getItem(int position) {
        return tarefas.get(position);
    }

    @Override
    public int getCount() {
        return tarefas.size();
    }

    @Override
    public void add(@Nullable Task object) {
        tarefas.add(object);
    }

//    @NonNull
//    @Override
//    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
//        LayoutInflater inflater = (LayoutInflater) this.getContext()
//                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//        View itemTarefa = inflater.inflate(R.layout.item_tarefa, parent,false);
//
//        Task tarefa = getItem(position);
//        TextView titulo = (TextView) itemTarefa.findViewById(R.id.titulo);
//        titulo.setText(tarefa.getDescription());
//        CheckBox status = (CheckBox) itemTarefa.findViewById(R.id.status);
//        status.setChecked(tarefa.getDone());

//        return itemTarefa;
//    }


}