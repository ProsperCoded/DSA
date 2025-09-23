package Sorting;

public class SelectionSort {
  public static int[] sort(int[] items) {
    for (int i = 0; i < items.length; i++) {
      // find minimum
      int min = i;
      for (int j = i + 1; j < items.length; j++) {
        if (items[j] < items[min]) {
          min = j;
        }
      }
      if (min != i) {
        // swap
        int temp = items[i];
        items[i] = items[min];
        items[min] = temp;
      }
    }
    return items;
  }

  public static void main(String[] args) {
    int[] list = { 1, 2, 3, 4, 2, 3, 2 };
    int[] sorted = sort(list);

    System.out.println(java.util.Arrays.toString(sorted));
  }
}
