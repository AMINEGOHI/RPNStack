package com.gohi.RPNStack.model;

import com.gohi.RPNStack.exception.FormatNotValid;
import com.gohi.RPNStack.exception.StartNotValid;
import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.Stack;
@Component
public class RPNStack {
    @Getter
    private Stack<Integer> stack;

    public RPNStack(){
        this.stack=new Stack<>();
    }
    //can use stream
    private boolean isNum(String sequence){
        try {
            Integer.parseInt(sequence);
        }catch (Exception e){
            return false;
        }
        return true;
    }
    public int CalculateLastTwoOperand( int RightOperand,int LeftOperand,String Operator){
        //we have 4 cases: "+","-","*",("d" or "/")
        switch (Operator) {
            case "+":
                return  LeftOperand + RightOperand;
            case "-":
                return  LeftOperand - RightOperand;
            case "*":
                return  LeftOperand * RightOperand;
            case "d":
                return  LeftOperand / RightOperand;
        }
        //throwException
        return 0;
    }

    public int calculate(String expression){
        if(startIsValidated(expression)){
            if (formatIsValidated(expression)){
                calculateOrPushToStack(expression);

            }else throw new FormatNotValid();
        }else throw new StartNotValid();
        return  stack.pop();
    }
    public boolean startIsValidated(String expression){
        String[] sequenceArray =expression.split(" ");
        return isNum(String.valueOf(sequenceArray[0])) && isNum(String.valueOf(sequenceArray[1]));
    }

     public boolean formatIsValidated(String expression){
        int operator =0,operand=0;
        for (String sequence :expression.split(" ")) {
            if (isNum(sequence)){
                ++operand;
            }else ++operator;
        }
        return operand==operator+1;
    }

    public void calculateOrPushToStack(String expression){
        for (String sequence :expression.split(" ")){
            if (isNum(sequence)){
                stack.push(Integer.parseInt(sequence));
            }else if(stack.size()>=2) {
                //DoTheMath
                stack.push(CalculateLastTwoOperand(stack.pop(),stack.pop(),sequence));
            }else {
                System.out.println("invalid stack size");
            }
        }

    }




}

