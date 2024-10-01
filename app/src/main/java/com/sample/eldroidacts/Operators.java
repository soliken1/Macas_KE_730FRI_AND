package com.sample.eldroidacts;

// Operators.java
public class Operators {
    private float num1;
    private float num2;

    public Operators(float num1, float num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    public float calculateSum() {
        return num1 + num2;
    }

    public float calculateDifference() {
        return num1 - num2;
    }

    public float calculateProduct() {
        return num1 * num2;
    }

    public float calculateQuotient() {
        return num1 / num2;
    }
}

