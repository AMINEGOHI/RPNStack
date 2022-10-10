package com.gohi.RPNStack.controller;

import com.gohi.RPNStack.service.StackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import java.util.Stack;

@RestController
@RequestMapping("/api")

public class StackController {
    @Autowired
    private StackService stackService;
    public StackController(StackService stackService){
        this.stackService=stackService;
    }
    @ApiIgnore
    @RequestMapping("/")
    public String home() {
        return "this should be a home page for Calculator";
    }
    @GetMapping("/get")
    public Stack<Integer> ListStack(){
        return stackService.getCalculatedStack();
    }
    @GetMapping("/cal/{Expression}")
    public int RPNCalculate(@PathVariable String Expression){
        return  stackService.calculateService(Expression);
    }
}

