package Trees;

import Trees.exercises.BinarySearchTreeIsBalanced;

public class Main {
  public static void main(String[] args) {
    var tree = new BinarySearchTreeIsBalanced();
    // tree.insert(7);
    // tree.insert(4);
    // tree.insert(9);
    // tree.insert(1);
    // tree.insert(6);
    // tree.insert(8);
    // tree.insert(10);

    tree.insert(1);
    tree.insert(2);
    tree.insert(3);
    tree.insert(4);
    tree.insert(5);

    // tree.transverseLevelOrder();
    System.out.println(tree.isBalanced());
  }
}