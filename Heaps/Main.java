package Heaps;

import java.util.Arrays;

import Heaps.exercises.Exercises;

public class Main {
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

  public static void main(String[] args) {
    Exercises utils = new Exercises();
    int[] items = { 11, 9, 4, 12, 10, 5 };
    int[] heapifiedItems = utils.heapiffy(items);
    System.out.println(Arrays.toString(heapifiedItems));
  }
}
