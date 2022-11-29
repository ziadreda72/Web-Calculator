package com.example.demo;

public class Inverter {
    private final double Operand;

    public Inverter(double Operand) {
        this.Operand = Operand;
    }

    public String invert(){
        double InvertingResult = 0;
        try {
            InvertingResult = 1 / Operand;
        }catch (Exception e){
            return "E";
        }
        return Double.toString(InvertingResult);
    }
}
