package Trees;

public class Main {
  public static void main(String[] args) {
    var tree = new BinarySearchTree();
    tree.insert(4);
    tree.insert(5);
    tree.insert(573);
    tree.insert(32);
    tree.insert(311);
    tree.insert(31);
    tree.insert(1);
    tree.insert(3);
    System.out.println(tree.find(13));
    System.out.println(tree.find(31));
  }
}