package com.sample.eldroidacts;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import java.util.ArrayList;

public class ListFragment extends Fragment {

    private ArrayList<String> todoList;
    private TodoAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);

        todoList = new ArrayList<>();
        ListView todoListView = view.findViewById(R.id.todoListView);
        EditText todoInput = view.findViewById(R.id.todoInput);
        Button addButton = view.findViewById(R.id.addButton);

        adapter = new TodoAdapter(getActivity(), todoList);
        todoListView.setAdapter(adapter);

        addButton.setOnClickListener(v -> {
            String todo = todoInput.getText().toString();
            if (!todo.isEmpty()) {
                todoList.add(todo);
                adapter.notifyDataSetChanged();
                todoInput.setText("");
            }
        });

        return view;
    }
}
