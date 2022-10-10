package com.gohi.RPNStack.exception;

public class StartNotValid extends RuntimeException{

    public StartNotValid(){
        super("equation should only begin with two numbers");
    }

}
