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
    resetHeight(root);

   return balance(root);
  }
  private AVLNode balance(AVLNode root){
 // Balance Factor 
    if(isLeftHeavy(root)){
      System.out.println("Node: (" + root.value + ") is left heavy");
      // Detecting rotations 
      if (balanceFactor(root.leftChild) >= 1){
        System.out.println("Rotation: Right Rotation of " + root.value);
        return rotateRight(root);
      }else if(balanceFactor(root.leftChild) <= -1){
        System.out.println("Rotation: RL of " + root.leftChild.value + " - "+ root.value);
        root.leftChild = rotateLeft(root.leftChild);
        root = rotateRight(root);
        return root;
      }
    }else if( isRightHeavy(root)){
      System.out.println("Node: (" + root.value + ") is right heavy");
      // Detecting rotations 
      if (balanceFactor(root.rightChild) <= -1){
        System.out.println("Rotation: Left Rotation of " + root.value);
        return rotateLeft(root);
      }else if(balanceFactor(root.rightChild) >= 1){
        System.out.println("Rotation: RL of " + root.rightChild.value + " - "+ root.value);
        root.rightChild = rotateRight(root.rightChild);
        root = rotateLeft(root);
        return root;
      }
    }
    // ? no need for balancing 
    return root;
  }
  private AVLNode rotateLeft(AVLNode root){
    var newRoot = root.rightChild;
    // if a node exists where we want to store root, we have to change that link
    root.rightChild = newRoot.leftChild;

    newRoot.leftChild = root;
    newRoot.height = Math.max(height(newRoot.leftChild), height(newRoot.rightChild));

    // ? calculate the height, with the new children 
    resetHeight(root);
    resetHeight(newRoot);
    return newRoot;
  }
  private AVLNode rotateRight(AVLNode root){
    var newRoot = root.leftChild;
    root.leftChild  = newRoot.rightChild;
    newRoot.rightChild = root;
    
    // ? calculate the height, with the new children 
    resetHeight(root);
    resetHeight(newRoot);
    return newRoot;
  }
  private void resetHeight(AVLNode node){
    node.height = Math.max(height(node.leftChild), height(node.rightChild)) + 1;
  }
  private boolean isLeftHeavy(AVLNode node){
    return balanceFactor(node) >  1;
  }
  private boolean isRightHeavy(AVLNode node){
    return balanceFactor(node) < -1;
  }
  private int balanceFactor(AVLNode node){
    return height(node.leftChild) -  height(node.rightChild);
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
