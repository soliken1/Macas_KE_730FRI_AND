package com.sample.calculator;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity {

    private TextView displayInputs;
    private TextView inputNumbers;
    private String concatInput = "";
    private String saveInput = "";

    private String operatorSelected = "";

    private float num1 = 0.00f;
    private float num2 = 0.00f;

    private float result = 0.00f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        displayInputs = findViewById(R.id.displayText);
        inputNumbers = findViewById(R.id.inputNumbers);

        Button zeroBtn = findViewById(R.id.zeroBtn);
        Button oneBtn = findViewById(R.id.oneBtn);
        Button twoBtn = findViewById(R.id.twoBtn);
        Button threeBtn = findViewById(R.id.threeBtn);
        Button fourBtn = findViewById(R.id.fourBtn);
        Button fiveBtn = findViewById(R.id.fiveBtn);
        Button sixBtn = findViewById(R.id.sixBtn);
        Button sevenBtn = findViewById(R.id.sevenBtn);
        Button eightBtn = findViewById(R.id.eightBtn);
        Button nineBtn = findViewById(R.id.nineBtn);

        Button plusBtn = findViewById(R.id.plusBtn);
        Button minusBtn = findViewById(R.id.minusBtn);
        Button timesBtn = findViewById(R.id.timesBtn);
        Button divideBtn = findViewById(R.id.divideBtn);
        Button equalsBtn = findViewById(R.id.equalsBtn);
        Button clearBtn = findViewById(R.id.clearBtn);

        oneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                concatInput = concatInput + "1";
                saveInput = saveInput + "1";
                inputNumbers.setText(saveInput);
            }
        });

        twoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                concatInput = concatInput + "2";
                saveInput = saveInput + "2";
                inputNumbers.setText(saveInput);
            }
        });

        threeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                concatInput = concatInput + "3";
                saveInput = saveInput + "3";
                inputNumbers.setText(saveInput);
            }
        });

        fourBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                concatInput = concatInput + "4";
                saveInput = saveInput + "4";
                inputNumbers.setText(saveInput);
            }
        });

        fiveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                concatInput = concatInput + "5";
                saveInput = saveInput + "5";
                inputNumbers.setText(saveInput);
            }
        });

        sixBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                concatInput = concatInput + "6";
                saveInput = saveInput + "6";
                inputNumbers.setText(saveInput);
            }
        });

        sevenBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                concatInput = concatInput + "7";
                saveInput = saveInput + "7";
                inputNumbers.setText(saveInput);
            }
        });

        eightBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                concatInput = concatInput + "8";
                saveInput = saveInput + "8";
                inputNumbers.setText(saveInput);
            }
        });

        nineBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                concatInput = concatInput + "9";
                saveInput = saveInput + "9";
                inputNumbers.setText(saveInput);
            }
        });

        zeroBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                concatInput = concatInput + "0";
                saveInput = saveInput + "0";
                inputNumbers.setText(saveInput);
            }
        });

        clearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                concatInput = "";
                saveInput = "";
                displayInputs.setText("");
                operatorSelected = "";
                inputNumbers.setText("");
            }
        });

        plusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operatorEvents("+");
            }
        });

        minusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operatorEvents("-");
            }
        });

        timesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operatorEvents("x");
            }
        });

        divideBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operatorEvents("/");
            }
        });

        equalsBtn.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("DefaultLocale")
            @Override
            public void onClick(View v) {
                num2 = Float.parseFloat((String) inputNumbers.getText());
                displayInputs.setText(concatInput);
                Operators operators;
                switch(operatorSelected) {
                    case "+":
                        operators = new Operators(num1, num2);
                        result = operators.calculateSum();
                        break;
                    case "-" :
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
        });
    }

    public void operatorEvents(String operator) {
        num1 = Float.parseFloat((String) inputNumbers.getText());
        operatorSelected = operator;
        concatInput = concatInput + " " + operator + " ";
        saveInput = "";
        inputNumbers.setText("");
        displayInputs.setText(concatInput);
    }
}