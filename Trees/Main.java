package Trees;

public class Main {
  public static void main(String[] args) {
    var tree = new TransverseBinaryTree();
    tree.insert(7);
    tree.insert(4);
    tree.insert(9);
    tree.insert(1);
    tree.insert(6);
    tree.insert(8);
    tree.insert(10);

    // tree.transverseLevelOrder();
    // System.out.println(tree.height());
    System.out.println(tree.getAncestors(5));
  }
}