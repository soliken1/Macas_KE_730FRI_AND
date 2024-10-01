package com.sample.eldroidacts;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ProfileFragment extends Fragment {

    private EditText nameEditText, ageEditText;
    private RadioButton maleRadioButton, femaleRadioButton;
    private CheckBox acceptTermsCheckBox;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        // Initialize views
        nameEditText = view.findViewById(R.id.nameEditText);
        ageEditText = view.findViewById(R.id.ageEditText);
        maleRadioButton = view.findViewById(R.id.maleRadioButton);
        femaleRadioButton = view.findViewById(R.id.femaleRadioButton);
        acceptTermsCheckBox = view.findViewById(R.id.acceptTermsCheckBox);
        Button saveButton = view.findViewById(R.id.saveButton);

        saveButton.setOnClickListener(v -> {
            String name = nameEditText.getText().toString();
            String age = ageEditText.getText().toString();
            String gender = maleRadioButton.isChecked() ? "Male" : "Female";
            boolean acceptedTerms = acceptTermsCheckBox.isChecked();

            // Show the details as a Toast for now
            Toast.makeText(getActivity(), "Name: " + name + "\nAge: " + age + "\nGender: " + gender + "\nAccepted Terms: " + acceptedTerms, Toast.LENGTH_LONG).show();
        });

        return view;
    }
}