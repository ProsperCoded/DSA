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

    // var equals = tree.equal(tree2);
    System.out.println(tree.find(6));
    System.out.println(tree.valuesAtKDistance(2));
  }
}