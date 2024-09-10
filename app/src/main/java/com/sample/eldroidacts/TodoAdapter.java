package com.sample.eldroidacts;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
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
        Button editButton = convertView.findViewById(R.id.editButton);
        Button deleteButton = convertView.findViewById(R.id.deleteButton);

        String currentTodo = todoList.get(position);
        todoText.setText(currentTodo);

        editButton.setOnClickListener(v -> {
            View dialogView = LayoutInflater.from(context).inflate(R.layout.dialog_edit_todo, null);
            EditText editTodoInput = dialogView.findViewById(R.id.editTodoInput);
            editTodoInput.setText(currentTodo);

            new AlertDialog.Builder(context)
                    .setTitle("Edit To-Do")
                    .setView(dialogView)
                    .setPositiveButton("Save", (dialog, which) -> {
                        String updatedTodo = editTodoInput.getText().toString();
                        if (!updatedTodo.isEmpty()) {
                            todoList.set(position, updatedTodo);
                            notifyDataSetChanged();
                        }
                    })
                    .setNegativeButton("Cancel", null)
                    .show();
        });

        deleteButton.setOnClickListener(v -> {
            todoList.remove(position);
            notifyDataSetChanged();
        });

        return convertView;
    }
}
