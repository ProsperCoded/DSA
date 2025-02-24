package Heaps.exercises;

import java.util.Arrays;

import Heaps.MaxHeap2;

public class Exercises {
  public int[] heapiffy(int[] items) {
    for (int i = 0; i < items.length; i++) {
      decideOperation(i, items);
    }
    return items;
  }

  public void decideOperation(int index, int[] items) {
    var validParent = isValidParent(index, items);
    var validChild = isValidChild(index, items);
    while (!validParent || !validChild) {
      if (!validParent) {
        bubbleDown(index, items);
      } else if (!validChild) {
        bubbleUp(index, items);
      }
      // recalculate
      validParent = isValidParent(index, items);
      validChild = isValidChild(index, items);
    }
  }

  public void bubbleDown(int index, int[] items) {
    int size = items.length - 1;
    while (index <= size && !isValidParent(index, items)) {
      var largerChildIndex = this.largerChildIndex(index, items);
      swap(index, largerChildIndex, items);
      index = largerChildIndex;
    }
  }

  private void bubbleUp(int index, int[] items) {

    while (index > 0 && !isValidChild(index, items)) {
      var parent = parentIndex(index);
      swap(index, parent, items);
      index = parent;
    }
  }

  private int largerChildIndex(int index, int[] items) {
    // ? can't have right child without left child in a heap
    if (!hasLeftChild(index, items))
      return index;

    if (!hasRightChild(index, items))
      return leftChildIndex(index);

    return (leftChild(index, items) > rightChild(index, items)) ? leftChildIndex(index) : rightChildIndex(index);
  }

  private void swap(int first, int second, int[] items) {
    var temp = items[first];
    items[first] = items[second];
    items[second] = temp;
  }

  private boolean isValidParent(int index, int[] items) {
    if (!hasLeftChild(index, items))
      return true;

    var validLeft = items[index] >= leftChild(index, items);
    if (!hasRightChild(index, items))
      return validLeft;
    return validLeft && items[index] >= rightChild(index, items);
  }

  private boolean isValidChild(int index, int[] items) {
    if (index == 0)
      return true;

    var parent = items[parentIndex(index)];
    return items[index] < parent;
  }

  private int leftChild(int index, int[] items) {
    return items[leftChildIndex(index)];
  }

  private int rightChild(int index, int[] items) {
    return items[rightChildIndex(index)];
  }

  private boolean hasLeftChild(int index, int[] items) {
    int size = items.length - 1;
    return leftChildIndex(index) <= size;
  }

  private boolean hasRightChild(int index, int[] items) {
    int size = items.length - 1;
    return rightChildIndex(index) <= size;
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

  public static void sort(int[] numbers) {
    var heap = new MaxHeap2();

    for (var number : numbers) {
      heap.insert(number);
    }

    // to sort incremental order, simply modify increment to go in reverse i.e (i--)
    for (var i = 0; i < numbers.length; i++) {
      numbers[i] = heap.remove();
    }
    System.out.println(Arrays.toString(numbers));
  }
}