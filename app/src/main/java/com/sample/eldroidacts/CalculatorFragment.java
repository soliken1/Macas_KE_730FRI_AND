package com.sample.eldroidacts;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class CalculatorFragment extends Fragment {

    private TextView displayInputs, inputNumbers;
    private String concatInput = "";
    private String saveInput = "";
    private float num1, num2, result;
    private String operatorSelected = "";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_calculator, container, false);

        displayInputs = view.findViewById(R.id.displayText);
        inputNumbers = view.findViewById(R.id.inputNumbers);

        Button zeroBtn = view.findViewById(R.id.zeroBtn);
        Button oneBtn = view.findViewById(R.id.oneBtn);
        Button twoBtn = view.findViewById(R.id.twoBtn);
        Button threeBtn = view.findViewById(R.id.threeBtn);
        Button fourBtn = view.findViewById(R.id.fourBtn);
        Button fiveBtn = view.findViewById(R.id.fiveBtn);
        Button sixBtn = view.findViewById(R.id.sixBtn);
        Button sevenBtn = view.findViewById(R.id.sevenBtn);
        Button eightBtn = view.findViewById(R.id.eightBtn);
        Button nineBtn = view.findViewById(R.id.nineBtn);

        Button plusBtn = view.findViewById(R.id.plusBtn);
        Button minusBtn = view.findViewById(R.id.minusBtn);
        Button timesBtn = view.findViewById(R.id.timesBtn);
        Button divideBtn = view.findViewById(R.id.divideBtn);
        Button equalsBtn = view.findViewById(R.id.equalsBtn);
        Button clearBtn = view.findViewById(R.id.clearBtn);

        oneBtn.setOnClickListener(v -> updateInput("1"));
        twoBtn.setOnClickListener(v -> updateInput("2"));
        threeBtn.setOnClickListener(v -> updateInput("3"));
        fourBtn.setOnClickListener(v -> updateInput("4"));
        fiveBtn.setOnClickListener(v -> updateInput("5"));
        sixBtn.setOnClickListener(v -> updateInput("6"));
        sevenBtn.setOnClickListener(v -> updateInput("7"));
        eightBtn.setOnClickListener(v -> updateInput("8"));
        nineBtn.setOnClickListener(v -> updateInput("9"));
        zeroBtn.setOnClickListener(v -> updateInput("0"));

        clearBtn.setOnClickListener(v -> clearInputs());

        plusBtn.setOnClickListener(v -> operatorEvents("+"));
        minusBtn.setOnClickListener(v -> operatorEvents("-"));
        timesBtn.setOnClickListener(v -> operatorEvents("x"));
        divideBtn.setOnClickListener(v -> operatorEvents("/"));

        equalsBtn.setOnClickListener(v -> calculateResult());

        return view;
    }

    private void updateInput(String number) {
        concatInput += number;
        saveInput += number;
        inputNumbers.setText(saveInput);
    }

    private void clearInputs() {
        concatInput = "";
        saveInput = "";
        displayInputs.setText("");
        operatorSelected = "";
        inputNumbers.setText("");
    }

    private void operatorEvents(String operator) {
        num1 = Float.parseFloat(inputNumbers.getText().toString());
        operatorSelected = operator;
        concatInput += " " + operator + " ";
        saveInput = "";
        inputNumbers.setText("");
        displayInputs.setText(concatInput);
    }

    @SuppressLint("DefaultLocale")
    private void calculateResult() {
        num2 = Float.parseFloat(inputNumbers.getText().toString());
        displayInputs.setText(concatInput);
        Operators operators;
        switch (operatorSelected) {
            case "+":
                operators = new Operators(num1, num2);
                result = operators.calculateSum();
                break;
            case "-":
                operators = new Operators(num1, num2);
                result = operators.calculateDifference();
                break;
            case "x":
                operators = new Operators(num1, num2);
                result = operators.calculateProduct();
                break;
            case "/":
                operators = new Operators(num1, num2);
                result = operators.calculateQuotient();
                break;
            default:
                break;
        }
        inputNumbers.setText(String.format("%.2f", result));
    }
}
