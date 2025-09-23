package Sorting;

import java.lang.*;
import java.util.ArrayList;

public class BubbleSort {

  public static int[] sort(int[] items) {
    int stop = items.length - 1;
    int start = 0;
    while (stop > 0) {
      if (start == stop) {
        // reset to start
        start = 0;
        stop--; // cover this block
      }
      if (items[start] > items[start + 1]) {
        // swap
        int temp = items[start];
        items[start] = items[start + 1];
        items[start + 1] = temp;
      }
      start++;
    }
    return items;
  }

  public static void main(String[] args) {
    int[] list = { 1, 2, 3, 4, 2, 3, 2 };
    int[] sorted = sort(list);

    System.out.println(java.util.Arrays.toString(sorted));
  }
}