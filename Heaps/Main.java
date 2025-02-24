package Heaps;

public class Main {
  public static void main(String[] args) {
    var heap = new MaxHeap2();
    heap.insert(10);
    heap.insert(9);
    heap.insert(8);
    heap.insert(4);
    heap.insert(5);
    heap.insert(6);
    heap.insert(7);
    heap.insert(11);
    System.out.println(heap.toString());
  }
}
