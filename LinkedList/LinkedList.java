package LinkedList;
import java.util.ArrayList;

public class LinkedList {
  private Node head;
  private Node tail;
  LinkedList(){
    this.head = null;
    this.tail = null;
  }
  public void addFirst(Integer value){
    Node node  = new Node(value);
    if(this.head==null){
      this.head = node;
      this.tail = node;
    }else{
      node.addNext(this.head);
      this.head = node;
    }
  }
  public void addLast(Integer value){
    Node node  = new Node(value);
    if(this.head == null){
      this.head = node;
      this.tail = node;
    }else{
      this.tail.addNext(node);
      this.tail = node;
    }
  }
  public void deleteFirst(){
    if(this.head != null){
      var reference  = this.head;
      // ? Previous head will be removed by default 
      this.head = this.head.next;
      // remove deleted node pointer to head, so it is garbage collected  
      reference.next = null;
    }
  }
  public void deleteLast(){
    Node currentNode = head;
    Node secondToLast = null;
    while(currentNode!= null){
      if(currentNode.next.next==null){
       secondToLast = currentNode;
       System.out.println("Second to Last: "+secondToLast.value);
      //  * remove pointer last element 
        currentNode.addNext(null);
        break;
      }

      currentNode = currentNode.next;
    }
    // * point to second to last element as the new tail
    this.tail = secondToLast;
  }

  public boolean contains(Integer value){
    return this.indexOf(value) != -1;
  }
  public Integer indexOf(Integer value){
    var currentNode = this.head;
    Integer trackIndex = 0;
    while(currentNode != null){
      if(currentNode.value == value){
        return trackIndex;
      }
      currentNode = currentNode.next;
      trackIndex++;
    }
    return -1;
  }
  public boolean isEmpty(){
    return this.head==null;
  }
  public boolean isSingleElement(){
    return this.head == this.tail;
  }
  public void reverse(){

    if(isEmpty() || isSingleElement()){
      // ? No need to reverse an empty or single element list
      return;
    }
    // * track the previous node 
    Node p = null;

    // * track the next node
    Node n = this.head;

    while (n!=null){
      // * temp variable for switching pointers
      var t = n;
      n = n.next;
      t.next = p;
      p = t;
    }
    // * switch head and tail respectively 
    var temp = this.head;
    this.head = this.tail;
    this.tail = temp;
  }
  public ArrayList<Integer> all(){
    ArrayList<Integer> arr = new ArrayList<Integer>();
    Node currentNode = head;
    while(currentNode!= null){
      arr.add(currentNode.value);
      currentNode = currentNode.next;
    }
    return arr;
  }
}
