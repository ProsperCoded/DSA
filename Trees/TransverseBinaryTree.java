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
    // public 
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
  private void transverseInOrder(Node root){
    if(root == null) return;

    transverseInOrder(root.leftChild);
    System.out.println(root.value);
    transverseInOrder(root.rightChild);
  }
}
