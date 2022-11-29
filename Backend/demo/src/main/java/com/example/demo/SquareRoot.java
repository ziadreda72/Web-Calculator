package com.example.demo;

public class SquareRoot {
    private final double Operand;

    public SquareRoot(double Operand) {
        this.Operand = Operand;
    }

    public String getSquareRoot(){
        if(Operand < 0){
            return "E";
        }
        double Result = Math.sqrt(Operand);
        return Double.toString(Result);
    }
}
