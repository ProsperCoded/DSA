package Stacks;

import java.util.Stack;

// package com.codewithmosh;


public class Main {
  // public static 
  // checking if string i                s a balanced expression
  public static void main                (String[] args) {
    var stack = new StackApplications("abc(d)]");
    
    System.out.println(stack.checkExpression());
  }
}
