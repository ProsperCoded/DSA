public class AVLTree {
  private class Node {
    private Node leftChild;
    private Node rightChild;
    private int value;

    public Node(int v){
      this.value = v;
    }
  }
  private Node root;

  // * Insertion with recursion 
  public void insert(int v){
    if(root  == null) {
      root = new Node(v);
      return;
    };
    insert(v, root);
  }
  public boolean isLeaf(Node node){
    return node.leftChild == null && node.rightChild == null;
  }
  private void insert(int v, Node parent){
    if(parent == null) return;

    if(v > parent.value){
      if(parent.rightChild == null){
        // insert right
        var node = new Node(v);
        parent.rightChild = node;
        return;
      }
      insert(v, parent.rightChild);
    }else {
      if(parent.leftChild == null){
        // insert left
        var node = new Node(v);
        parent.leftChild = node;
        return;
      }
      insert(v, parent.leftChild);
    }
  }

  // * Printing values 
  public void transverseInOrder(){
    this.transverseInOrder(root);
  }
  private void transverseInOrder(Node root){
    if(root == null) return;

    transverseInOrder(root.leftChild);
    System.out.println(root.value);
    transverseInOrder(root.rightChild);
  }
}
