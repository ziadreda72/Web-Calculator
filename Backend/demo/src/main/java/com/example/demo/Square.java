package com.example.demo;

public class Square {
    private final double Operand;

    public Square(double Operand) {
        this.Operand = Operand;
    }

    public String getSquare(){
        double SquaringResult = Operand * Operand;
        return Double.toString(SquaringResult);
    }
}
