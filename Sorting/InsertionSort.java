package Sorting;

public class InsertionSort {
  public static int[] sort(int[] items) {
    if (items.length <= 1) {
      return items;
    }
    for (int i = 1; i < items.length; i++) {
      int current = i;
      while (current > 0 && items[current] < items[current - 1]) {
        int temp = items[current - 1];
        items[current - 1] = items[current];
        items[current] = temp;
        current--;
      }
    }
    return items;
  }

  public static void main(String[] args) {
    int[] list = { 1, 2, 5, 4, 2, 3, 2 };
    int[] sorted = sort(list);

    System.out.println(java.util.Arrays.toString(sorted));
  }
}
