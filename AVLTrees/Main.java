
// package AVLTrees;

public class Main {
  public static void main(String[] args) {
    var tree = new AVLTree();
    tree.insert2(10);
    tree.insert2(20);
    tree.insert2(15);
    tree.insert2(30);

    tree.transverseInOrder();
  }
}