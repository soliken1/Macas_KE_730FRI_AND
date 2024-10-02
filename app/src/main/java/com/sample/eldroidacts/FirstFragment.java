package com.sample.eldroidacts;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FirstFragment extends Fragment {

    private int cookieCount = 0;
    private TextView counterTextView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.first_fragment, container, false);

        counterTextView = view.findViewById(R.id.counter);
        Button counterButton = view.findViewById(R.id.counterBtn);

        counterButton.setOnClickListener(v -> {
            cookieCount++;
            counterTextView.setText(String.valueOf(cookieCount));
        });

        return view;
    }
}
