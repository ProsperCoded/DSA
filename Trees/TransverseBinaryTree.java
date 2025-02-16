package Trees;

import javax.swing.TransferHandler.TransferSupport;

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
  private boolean isLeaf(Node node){
    return node.leftChild == null && node.rightChild==null;
  }
  private int height(Node root){
    if(root == null) return -1;
    if(isLeaf(root)) return 0;

    var l = height(root.leftChild);
    var r = height(root.rightChild);
    System.out.println(root.value);
    return 1+ max(l, r);
  }
  public int min(){
    return min(root);
  }
  // ! This  can be used with BinarySearchTree and Binary Tree
  private int min(Node root){
    if(root == null) return Integer.MAX_VALUE;
    if(isLeaf(root)) return root.value;
    var l = min(root.leftChild);
    var r = min(root.rightChild);

    return min(min(l, r), root.value);
  }

  // ! This should only be used with Binary Search Tree
  private int minSearchTree(Node root){
    if(root == null) throw new IllegalStateException();

    var current  = root;
    var parent  =  current;

    while(current!=null){
      parent = current;
      // * go to the minimum element, which is always at the left
      current = current.leftChild;
    }

    return parent.value;
  }
  // Check if tree equals another 
  public boolean equal(TransverseBinaryTree tree){
    if(tree == null) return false;
    return equals(root, tree.root);
  }
  // ? solution by me(prosper coded)
  private boolean equals(Node tree1, Node tree2){
    // * both has the same tail 
    if(tree1 == null && tree2 == null) return true;

    if(tree1 == null || tree2 == null) {
      return false;
    };

    if(tree1.value != tree2.value) {
      return false;
    };

    // recursively check the left and right node 
    var leftEqual = equals(tree1.leftChild, tree2.leftChild);
    var rightEqual = equals(tree1.rightChild, tree2.rightChild);

    return leftEqual && rightEqual;
  }

  // ? solution by tutorial
  private boolean equals2(Node first, Node second){
    if( first == null && second == null) return true;

    if(first != null && second != null){
      return first.value == second.value && equals2(first.leftChild, second.leftChild) && equals2(first.rightChild, second.rightChild);
    }

    // * case where one is null and the other is not 
    return false;
  }

  public boolean isBinarySearchTree(){
    //                       NODE ,   INFINITY,       INFINITY
    return isBinarySearchTree(root,  Integer.MIN_VALUE,Integer.MAX_VALUE);
  }
  private boolean isBinarySearchTree(Node node, int min, int max){
    if (node == null) return true;
    if(node.value > max || node.value < min){
      return false;
    }
    var leftIsValid = isBinarySearchTree(node.leftChild, min, node.value - 1);
    // optimized if the left is false, don't check right 
    if(!leftIsValid) return false;
    var rightIsValid = isBinarySearchTree(node.rightChild, node.value + 1, max);

    return rightIsValid;
  }
}
