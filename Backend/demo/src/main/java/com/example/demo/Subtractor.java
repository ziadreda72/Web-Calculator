package com.example.demo;

public class Subtractor {
    private final double FirstOperand;
    private final double SecondOperand;

    public Subtractor(double firstOperand, double secondOperand) {
        FirstOperand = firstOperand;
        SecondOperand = secondOperand;
    }

    public String sub(){
        double SubtractionResult = FirstOperand - SecondOperand;
        return Double.toString(SubtractionResult);
    }
}
