package Heaps;

import java.util.Arrays;

// solution from tutorial
public class MaxHeap2 {
  private int[] items = new int[10];
  private int size;

  public void insert(int value) {

    if (isFull()) {
      throw new IllegalStateException();
    }
    items[size++] = value;

    bubbleUp();
  }

  public int remove() {
    // todo remove the last item
    if (isEmpty()) {
      throw new IllegalStateException();
    }
    var root = items[0];
    items[0] = items[--size];
    bubbleDown();
    return root;
  }

  private void bubbleDown() {
    var index = 0;

    while (index <= size && !isValidParent(size)) {
      var largerChildIndex = this.largerChildIndex(size);
      swap(index, largerChildIndex);
      index = largerChildIndex;
    }
  }

  private void bubbleUp() {

    var index = size - 1;
    while (index > 0 && items[index] > items[parentIndex(index)]) {
      swap(index, parentIndex(index));
      index = parentIndex(index);
    }
  }

  private int largerChildIndex(int index) {
    // ? can't have right child without left child in a heap
    if (!hasLeftChild(index))
      return index;

    if (!hasRightChild(index))
      return leftChildIndex(index);

    return (leftChild(index) > rightChild(index)) ? leftChildIndex(index) : rightChildIndex(index);
  }

  private boolean hasLeftChild(int index) {
    return leftChildIndex(index) <= size;
  }

  private boolean hasRightChild(int index) {
    return rightChildIndex(index) <= size;
  }

  public boolean isFull() {
    return size == items.length;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  private boolean isValidParent(int index) {
    if (!hasLeftChild(index))
      return true;

    if (!hasRightChild(index))
      return items[index] >= leftChild(index);
    return items[index] >= leftChild(index) && items[index] >= rightChild(index);
  }

  private int leftChild(int index) {
    return items[leftChildIndex(index)];
  }

  private int rightChild(int index) {
    return items[rightChildIndex(index)];
  }

  private int parentIndex(int index) {
    return (index - 1) / 2;
  }

  private int leftChildIndex(int index) {
    return index * 2 + 1;
  }

  private int rightChildIndex(int index) {
    return index * 2 + 2;
  }

  private void swap(int first, int second) {
    var temp = items[first];
    items[first] = items[second];
    items[second] = temp;
  }

  @Override
  public String toString() {

    return Arrays.toString(Arrays.copyOfRange(this.items, 0, this.size));
  }
}
