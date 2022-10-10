package com.gohi.RPNStack.exception;

public class FormatNotValid extends RuntimeException{
    public FormatNotValid(){
        super("Operators are more than operand!!!");
    }
}
