package Trees;

public class Main {
  public static void main(String[] args) {
    var tree = new TransverseBinaryTree();
    tree.insert(4);
    tree.insert(3);
    tree.insert(1);
    tree.insert(2);
    tree.insert(5);
    tree.insert(6);
    tree.insert(7);
    // tree.insert(8);
    // tree.insert(9);
    // tree.insert(10);
    var min = tree.min();
    System.err.println("Minium");
    System.err.println(min);
  }
}