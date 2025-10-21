package Heaps;

// ? Implementing priority queue with a Heap rather than an array (faster insertion slower deletes)
// * Insertion  - O(log n)
// * Deletion   - O(log n)

public class PriorityQueue {
  private MaxHeap_Mosh heap = new MaxHeap_Mosh();

  public void enqueue(int item) {
    heap.insert(item);
  }

  public int dequeue() {
    return heap.remove();
  }

  public boolean isEmpty() {
    return heap.isEmpty();
  }
}
