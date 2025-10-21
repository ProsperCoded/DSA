package Sorting;

// use when
// allocating extra space is not an issue 
// values are positive integers
// most of the values in the range are present 
public class CountingSort {

  public static void sort(int[] items) {
    int size = getMax(items);

    int[] itemsFreq = new int[size + 1];

    // store frequencies in order
    for (int i = 0; i < items.length; i++) {
      int value = items[i];
      itemsFreq[value]++;
    }

    // rearrange
    int i = 0;
    int j = 0;
    while (i < itemsFreq.length) {
      if (itemsFreq[i] == 0) {
        i++;
        continue;
      }
      items[j++] = i;
      itemsFreq[i]--;
    }
  }

  public static int getMax(int[] items) {
    var max = items[0];
    for (int i = 1; i < items.length; i++) {
      if (items[i] > max)
        max = items[i];
    }
    return max;
  }

  public static void main(String[] args) {
    int[] list = { 2, 1, 4, 5, 3, 1, 3, 22 };
    // int[] list = { 3, 2, 4 };
    sort(list);

    System.out.println(java.util.Arrays.toString(list));
  }
}
