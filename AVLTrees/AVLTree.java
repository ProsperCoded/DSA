public class AVLTree {
  private class AVLNode {
    private AVLNode leftChild;
    private AVLNode rightChild;
    private int value;
    public int height;
    public AVLNode(int v){
      this.value = v;
    }
    @Override
    public String toString(){
      return "Value = " + value;
    }
  }
  private AVLNode root;

  public boolean isLeaf(AVLNode node){
    return node.leftChild == null && node.rightChild == null;
  }

  // * Insertion with recursion 
  public void insert(int v){
    if(root  == null) {
      root = new AVLNode(v);
      return;
    };
    insert(v, root);
  }
  private void insert(int v, AVLNode parent){
    if(parent == null) return;

    if(v > parent.value){
      if(parent.rightChild == null){
        // insert right
        var node = new AVLNode(v);
        parent.rightChild = node;
        return;
      }
      insert(v, parent.rightChild);
    }else {
      if(parent.leftChild == null){
        // insert left
        var node = new AVLNode(v);
        parent.leftChild = node;
        return;
      }
      insert(v, parent.leftChild);
    }
  }
  // ? Recursion insertion from mosh
  public void insert2(int value){
    root = insert2(value, root);
  }
  private AVLNode insert2(int value, AVLNode root){
    if(root == null){
      return new AVLNode(value);
    }
    if(value > root.value){
      root.rightChild = insert2(value, root.rightChild);
    }else {
      root.leftChild = insert2( value,root.leftChild);
    }
    var height = Math.max(height(root.rightChild), height(root.leftChild)) + 1;
    root.height = height;
    return root;
  }
  public int height(AVLNode node){
    return (node == null) ? -1 : node.height;
  }
  // * Printing values 
  public void transverseInOrder(){
    this.transverseInOrder(root);
  }
  private void transverseInOrder(AVLNode root){
    if(root == null) return;

    transverseInOrder(root.leftChild);
    System.out.println(root.value);
    transverseInOrder(root.rightChild);
  }
}
