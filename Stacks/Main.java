package Stacks;

import java.util.Stack;

// package com.codewithmosh;


public class Main {
  // public static 
  // checking if string i                s a balanced expression
  public static void main(String[] args) {
    var stack = new CustomStack();
    stack.push(3);
    stack.push(3);
    stack.push(3);
    stack.push(3);
    stack.push(5);

    System.out.println(java.util.Arrays.toString(stack.get()));
    System.out.println(stack.peek());
  
  
  }
}
