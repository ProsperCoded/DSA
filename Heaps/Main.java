package Heaps;

import java.util.Arrays;

public class Main {
  public static void sort(int[] numbers) {
    var heap = new MaxHeap2();

    for (var number : numbers) {
      heap.insert(number);
    }

    for (var i = 0; i < numbers.length; i++) {
      numbers[i] = heap.remove();
    }
    System.out.println(Arrays.toString(numbers));
  }

  public static void main(String[] args) {
    int[] numbers = { 5, 3, 10, 1, 4, 2 };
    sort(numbers);
  }
}
