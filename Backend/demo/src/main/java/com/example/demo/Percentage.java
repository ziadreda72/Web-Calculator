package com.example.demo;

public class Percentage {
    private final double Operand;

    public Percentage(double Operand) {
        this.Operand = Operand;
    }

    public String getPercentage(){
        double Result = Operand / 100;
        return Double.toString(Result);
    }
}
