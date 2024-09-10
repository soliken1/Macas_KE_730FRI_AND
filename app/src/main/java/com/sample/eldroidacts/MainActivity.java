package com.sample.eldroidacts;

import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<String> todoList;
    private TodoAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        todoList = new ArrayList<>();
        ListView todoListView = findViewById(R.id.todoListView);
        EditText todoInput = findViewById(R.id.todoInput);
        Button addButton = findViewById(R.id.addButton);

        adapter = new TodoAdapter(this, todoList);
        todoListView.setAdapter(adapter);

        addButton.setOnClickListener(view -> {
            String todo = todoInput.getText().toString();
            if (!todo.isEmpty()) {
                todoList.add(todo);
                adapter.notifyDataSetChanged();
                todoInput.setText("");
            }
        });
    }
}

