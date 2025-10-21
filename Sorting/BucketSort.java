package Sorting;

// More buckets = faster sorting but more memory usage 
// Best when input is uniformly distributed over a range
public class BucketSort {
  public static void sort(int[] array) {
    if (array.length == 0)
      return;

    // Find max and min values
    int min = array[0];
    int max = array[0];
    for (int i = 1; i < array.length; i++) {
      if (array[i] < min)
        min = array[i];
      if (array[i] > max)
        max = array[i];
    }

    // Create buckets
    int bucketCount = (max - min) / array.length + 1;
    int[][] buckets = new int[bucketCount][0];

    // Distribute input array values into buckets
    for (int i = 0; i < array.length; i++) {
      int bucketIndex = (array[i] - min) / bucketCount;
      buckets[bucketIndex] = append(buckets[bucketIndex], array[i]);
    }

    // Sort each bucket and concatenate results
    int index = 0;
    for (int i = 0; i < buckets.length; i++) {
      int[] sortedBucket = insertionSort(buckets[i]);
      for (int j = 0; j < sortedBucket.length; j++) {
        array[index++] = sortedBucket[j];
      }
    }
  }

  private static int[] append(int[] array, int value) {
    int[] newArray = new int[array.length + 1];
    System.arraycopy(array, 0, newArray, 0, array.length);
    newArray[array.length] = value;
    return newArray;
  }

  private static int[] insertionSort(int[] array) {
    for (int i = 1; i < array.length; i++) {
      int key = array[i];
      int j = i - 1;
      while (j >= 0 && array[j] > key) {
        array[j + 1] = array[j];
        j--;
      }
      array[j + 1] = key;
    }
    return array;
  }

  public static void main(String[] args) {
    int[] list = { 2, 1, 4, 5, 3, 1, 3, 22 };
    // int[] list = { 3, 2, 4 };
    sort(list);

    System.out.println(java.util.Arrays.toString(list));
  }
}
