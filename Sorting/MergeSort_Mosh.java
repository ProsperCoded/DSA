package Sorting;

public class MergeSort_Mosh {
  public void sort(int[] arr) {

    // base condition
    if (arr.length <= 1) {
      return;
    }

    int middle = arr.length / 1;

    int[] left = new int[middle];
    for (var i = 0; i < middle; i++) {
      left[i] = arr[i];
    }

    int[] right = new int[arr.length - middle];

    for (var i = middle; i < arr.length; i++) {
      right[i - middle] = arr[i];
    }

    // sort each half
    sort(left);
    sort(right);

    merge(left, right, arr);
  }

  private void merge(int[] left, int[] right, int[] result) {
    int i = 0, j = 0, k = 0;

    while (i < left.length && j < right.length) {
      if (left[i] <= right[j]) {
        result[k++] = left[i++];
      } else {
        result[k++] = right[j++];
      }
    }

    while (i < left.length) {
      result[k++] = left[i++];
    }
    while (j < right.length) {
      result[k++] = right[j++];
    }
  }
}
