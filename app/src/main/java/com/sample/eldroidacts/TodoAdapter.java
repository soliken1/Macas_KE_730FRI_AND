package com.sample.eldroidacts;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;

import java.util.ArrayList;

public class TodoAdapter extends ArrayAdapter<String> {

    private final Context context;
    private final ArrayList<String> todoList;

    public TodoAdapter(Context context, ArrayList<String> todoList) {
        super(context, R.layout.list_item, todoList);
        this.context = context;
        this.todoList = todoList;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_item, parent, false);
        }

        CheckBox checkBox = convertView.findViewById(R.id.checkBox);
        TextView todoText = convertView.findViewById(R.id.todoText);

        String currentTodo = todoList.get(position);
        todoText.setText(currentTodo);

        convertView.setOnClickListener(v -> {
            showEditDeleteDialog(position);
        });

        return convertView;
    }

    private void showEditDeleteDialog(int position) {
        String currentTodo = todoList.get(position);

        View dialogView = LayoutInflater.from(context).inflate(R.layout.dialog_edit_todo, null);
        EditText editTodoInput = dialogView.findViewById(R.id.editTodoInput);
        editTodoInput.setText(currentTodo);

        new AlertDialog.Builder(context)
                .setTitle("Edit or Delete To-Do")
                .setView(dialogView)
                .setPositiveButton("Edit", (dialog, which) -> {
                    String updatedTodo = editTodoInput.getText().toString();
                    if (!updatedTodo.isEmpty()) {
                        todoList.set(position, updatedTodo);
                        notifyDataSetChanged();
                    }
                })
                .setNegativeButton("Delete", (dialog, which) -> {
                    todoList.remove(position);
                    notifyDataSetChanged();
                })
                .setNeutralButton("Cancel", null)
                .show();
    }
}

