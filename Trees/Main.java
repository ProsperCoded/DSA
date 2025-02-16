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
  
    var tree2 = new TransverseBinaryTree();
    tree2.insert(4);
    tree2.insert(3);
    tree2.insert(1);
    tree2.insert(2);
    tree2.insert(5);
    tree2.insert(6);
    tree2.insert(7);

    var equals = tree.equal(tree2);
    System.out.println(equals);
  }
}