package com.example.demo;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.apache.catalina.startup.AddPortOffsetRule;
import org.springframework.web.bind.annotation.*;

import java.awt.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/calculate")
public class Calculator {
    @PostMapping("/expression")

    public String Calculate(@RequestBody String expression){
        expression = expression.substring(0 , expression.length() - 1);
        expression = expression.replaceAll(" ","");
        double FirstOperand = 0 , SecondOperand = 0;
        char Operator = 0;
        String str = "";
        int idx = 0;
        if (expression.charAt(0) == '-'){
            str += '-';
            idx++;
        }
        for (int i = idx ; i < expression.length() ; ++i){
            if ((expression.charAt(i) >= '0' && expression.charAt(i) <= '9') || (expression.charAt(i) == '.')) {
                str += expression.charAt(i);
            }
            else {
                Operator = expression.charAt(i);
                FirstOperand = Double.parseDouble(str);
                str = expression.substring(i + 1 , expression.length());
                if (str.isEmpty() && Operator != 'r' && Operator != 'n' && Operator != 's' && Operator != '%'){
                    return Double.toString(FirstOperand);
                }
                else if(!str.isEmpty()){
                    SecondOperand = Double.parseDouble(str);
                }
                break;
            }
        }
        if (Operator == 0){
            FirstOperand = Double.parseDouble(str);
            return Double.toString(FirstOperand);
        }
        if (Operator == '+'){
            var adder = new Adder(FirstOperand , SecondOperand);
            return adder.add();
        }
        if (Operator == '-'){
            var subtractor = new Subtractor(FirstOperand , SecondOperand);
            return subtractor.sub();
        }
        if (Operator == '*'){
            var multiplier = new Multiplier(FirstOperand , SecondOperand);
            return multiplier.mul();
        }
        if (Operator == '/'){
            var divider = new Divider(FirstOperand , SecondOperand);
            return divider.divide();
        }
        if (Operator == '%'){
            var percent = new Percentage(FirstOperand);
            return percent.getPercentage();
        }
        if (Operator == 's'){
            var square = new Square(FirstOperand);
            return square.getSquare();
        }
        if(Operator == 'r'){
            var root = new SquareRoot(FirstOperand);
            return root.getSquareRoot();
        }
        if (Operator == 'n'){
            var inverter = new Inverter(FirstOperand);
            return inverter.invert();
        }
        return "E";
    }
}
