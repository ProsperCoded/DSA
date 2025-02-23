package Heaps;

import java.util.ArrayList;

public class MaxHeap {
  ArrayList<Integer> heap = new ArrayList<>();

  public void insert(int v) {
    if (heap.isEmpty()) {
      heap.add(v);
      return;
    }
    var insertIndex = heap.size();
    var parentIndex = getParentIndex(insertIndex);
    // heap.set(insertIndex, v);
    heap.add(v); // instead of set due to index out of bound
    while (parentIndex >= 0 && v > heap.get(parentIndex)) {
      // bubble up
      swap(parentIndex, insertIndex);
      insertIndex = parentIndex;
      parentIndex = getParentIndex(insertIndex);
    }
  }

  public void remove(int v) {
    var removeIndex = heap.indexOf(v);
    if (removeIndex == -1) {
      throw new IllegalStateException();
    }

    // remove value at removeLocation, and switch it to the last element
    var poppedFromHeap = heap.removeLast();
    heap.set(removeIndex, poppedFromHeap);
    var currentIndex = removeIndex;

    var left = getLeftIndex(currentIndex);
    var right = getRightIndex(currentIndex);
    while (right < heap.size() && poppedFromHeap < Math.max(heap.get(left), heap.get(right))) {
      if (heap.get(left) > poppedFromHeap) {
        swap(left, currentIndex);
        currentIndex = left;
      } else if (heap.get(right) > poppedFromHeap) {
        swap(right, currentIndex);
        currentIndex = right;
      }
      left = getLeftIndex(currentIndex);
      right = getRightIndex(currentIndex);
    }
  }

  private void swap(int ind1, int ind2) {
    var temp = heap.get(ind1);
    heap.set(ind1, heap.get(ind2));
    heap.set(ind2, temp);
  }

  private int getLeftIndex(int parentIndex) {
    return parentIndex * 2 + 1;
  }

  private int getRightIndex(int parentIndex) {
    return parentIndex * 2 + 2;
  }

  private int getParentIndex(int childIndex) {
    return Math.floorDiv((childIndex - 1), 2);
  }

  @Override
  public String toString() {
    return heap.toString();
  }
}
