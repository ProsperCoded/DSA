package Trees.exercises;

// * Check if Binary tree is balanced
public class BinarySearchTreeIsBalanced {
  protected class Node {
    public Node leftChild;
    public Node rightChild;
    public int value;
    public int height;
    public Node(int v){
      this.value = v;
    }
    
    @Override
    public String toString(){
      return "value = " + value;
    }
  }
  protected Node root;

  public void insert(int v){
    if(root == null){
      root = new Node(v);
      setHeight(root);
      return;
    }
    Node current = root;
    Node lastParent = null;
    while (current != null){
      lastParent = current;
      if(v > current.value){
        current = current.rightChild;
      }else {
        current = current.leftChild;
      }
      // * track the parent, so we can add data later
    }
    if(v > lastParent.value){
      lastParent.rightChild = new Node(v);
    } else if(v <= lastParent.value){
      lastParent.leftChild = new Node(v);
    }
    resetHeights(root);
  };
  public void resetHeights(Node root){
    if(root == null) return;
    resetHeights(root.leftChild);
    resetHeights(root.rightChild);
    setHeight(root);
  }
  public void setHeight(Node root){
    if(root == null) return;
    root.height =  Math.max(height(root.leftChild), height(root.rightChild)) + 1;
  }
  public boolean isBalanced(){
    return isBalanced(root);
  }
  private boolean isBalanced(Node root){
    if (root == null) return true;
    var leftIsBalanced = isBalanced(root.leftChild);
    var rightIsBalanced = isBalanced(root.rightChild);

    var rootIsBalanced =  !isLeftHeavy(root)&& !isRightHeavy(root);
    return rootIsBalanced && leftIsBalanced && rightIsBalanced;
  }

  private boolean isLeftHeavy(Node node){
    return balanceFactor(node) >  1;
  }
  private boolean isRightHeavy(Node node){
    return balanceFactor(node) < -1;
  }
  public int height(Node node){
    return node == null ? -1 : node.height;
  }
  private int balanceFactor(Node node){
    return height(node.leftChild) -  height(node.rightChild);
  }

  public boolean isPerfect(){
    return isPerfect(root);
  }
  private boolean isPerfect(Node root){
    if(root == null) return true;
    var leftIsPerfect = isPerfect(root.leftChild);
    var rightIsPerfect = isPerfect(root.rightChild);

    var rootIsPerfect = (root.leftChild == null && root.rightChild == null) || (root.leftChild != null && root.rightChild != null);

    return rootIsPerfect && leftIsPerfect && rightIsPerfect;

  }
}
