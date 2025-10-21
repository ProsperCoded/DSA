package Sorting;

public class CountingSort_Mosh {
  public void sort(int[] array, int max) {
    int[] counts = new int[max + 1];

    for (var number : array)
      counts[number]++;

    int j = 0;
    for (int i = 0; i < counts.length; i++) {
      while (counts[i] > 0) {
        array[j++] = i;
        counts[i]--;
      }
    }
  }
}
