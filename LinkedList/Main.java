package LinkedList;
// package com.codewithmosh;


public class Main {
  public static void main(String[] args) {
    System.out.println("Hello world!");
    LinkedList list = new LinkedList();
    list.addLast(1);
    list.addLast(2);
    // list.addLast(3);
    list.reverse();
    String values = list.all().toString();
    System.out.println(values);
  }
}
