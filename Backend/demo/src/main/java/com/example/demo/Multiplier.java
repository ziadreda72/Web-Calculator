package com.example.demo;

public class Multiplier {
    private final double FirstOperand;
    private final double SecondOperand;

    public Multiplier(double firstOperand, double secondOperand) {
        FirstOperand = firstOperand;
        SecondOperand = secondOperand;
    }

    public String mul(){
        double MultiplicationResult = FirstOperand * SecondOperand;
        return Double.toString(MultiplicationResult);
    }
}
