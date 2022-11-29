package com.example.demo;

public class Divider {
    private final double FirstOperand;
    private final double SecondOperand;

    public Divider(double firstOperand, double secondOperand) {
        FirstOperand = firstOperand;
        SecondOperand = secondOperand;
    }

    public String divide(){
        double DivisionResult = 0;
        if(SecondOperand == 0){
            return "E";
        }
        try {
            DivisionResult = FirstOperand / SecondOperand;
        }
        catch(Exception e) {
            return "E";
        }
        return Double.toString(DivisionResult);
    }
}
