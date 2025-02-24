package Trees;

import Trees.exercises.Exercises;

public class Main {
  public static void main(String[] args) {
    var tree = new Exercises();
    tree.insert(7);
    tree.insert(4);
    tree.insert(9);
    tree.insert(1);
    tree.insert(6);
    tree.insert(8);
    System.out.println(tree.isPerfect());
    tree.insert(10);
    System.out.println(tree.isPerfect());
  }
}