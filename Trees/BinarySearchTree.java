package Trees;

public class BinarySearchTree {
  private class Node {
    public Node leftChildNode;
    public Node rightChildNode;
    public int value;

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
        current = current.rightChildNode;
        
      }else {
        current = current.leftChildNode;
      }
      // * track the parent, so we can add data later
    }
    if(v > lastParent.value){
      lastParent.rightChildNode = new Node(v);
    } else if(v <= lastParent.value){
      lastParent.leftChildNode = new Node(v);
    }
  };
  public boolean find(int v){
    Node current = root;

    while (current != null){
      if(v > current.value){
        current = current.rightChildNode;
      } else if(v < current.value){
        current = current.leftChildNode;
      }else{
        // It is equal to the value 
        return true;
      }
    }
    return false;
  };
}
