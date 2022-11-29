package com.example.demo;

import java.math.BigDecimal;

public class Adder {

    private final double FirstOperand;
    private final double SecondOperand;

    public Adder(double firstOperand, double secondOperand) {
        FirstOperand = firstOperand;
        SecondOperand = secondOperand;
    }

    public String add(){
        double SummationResult = FirstOperand + SecondOperand;
        return Double.toString(SummationResult);
    }
}
