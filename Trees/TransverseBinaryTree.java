package Trees;

// * My solution
public class TransverseBinaryTree {
  private class Node {
    private Node leftChild;
    private Node rightChild;
    private int value;

    public Node(int v){
      this.value = v;
    }
  }
  private Node root;

  public void insert(int v){
    if(root == null){
      root = new Node(v);
      return;
    }
    Node current = root;
    Node lastParent = null;
    while (current != null){
      lastParent = current;
      if(v > root.value){
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
  };
  public boolean find(int v){
    Node current = root;

    while (current != null){
      if(v > current.value){
        current = current.rightChild;
      } else if(v < current.value){
        current = current.leftChild;
      }else{
        // It is equal to the value 
        return true;
      }
    }
    return false;
  };

  public void transverseInOrder(){
    this.transverseInOrder(root);
  }
  public void transversePostOrder(){
    this.transversePostOrder(root);
  }
  public void transversePreOrder(){
    this.transversePreOrder(root);
  }

  private void transverseInOrder(Node root){
    if(root == null) return;

    transverseInOrder(root.leftChild);
    System.out.println(root.value);
    transverseInOrder(root.rightChild);
  }
  private void transversePreOrder(Node root){
    if(root == null) return;

    System.out.println(root.value);
    transverseInOrder(root.leftChild);
    transverseInOrder(root.rightChild);
  }
  private void transversePostOrder(Node root){
    if(root == null) return;

    transverseInOrder(root.leftChild);
    transverseInOrder(root.rightChild);
    System.out.println(root.value);
  }
  private int max(int l, int r){
    if(l > r) return l;
    return l;
  }
  private int min(int l, int r){
    if(l > r) return r;
    return l;
  }
  public int height(){
    return height(root);
  }
  private int height(Node root){
    if(root == null) return -1;
    if(root.leftChild == null && root.rightChild==null) return 0;

    var l = height(root.leftChild);
    var r = height(root.rightChild);
    System.out.println(root.value);
    return 1+ max(l, r);
  }
  public int min(){
    return min(root);
  }
  private int min(Node root){
    if(root == null) return Integer.MAX_VALUE;
    if(root.leftChild == null && root.rightChild==null) return root.value;
    var l = min(root.leftChild);
    var r = min(root.rightChild);

    return min(min(l, r), root.value);
  }

}
