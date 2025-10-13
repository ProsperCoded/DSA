package Sorting;

public class MergeSort {
  public static int[] sort(int[] items) {
    if (items.length == 1) {
      return items;
    }
    int[][] splitedArray = split(items);
    return split_merge(splitedArray[0], splitedArray[1], items);

  }

  // recursive function
  public static int[] split_merge(int[] left, int[] right, int[] bucket) {
    // bucket is to manage space
    if (left.length == 1 && right.length == 1) {
      return merge(left, right, bucket);
    }
    if (left.length > 1) {
      int[][] splitedArray = split(left);
      left = split_merge(splitedArray[0], splitedArray[1], left); // merged left
    }
    if (right.length > 1) {
      int[][] splitedArray = split(right);
      right = split_merge(splitedArray[0], splitedArray[1], right); // merged right
    }
    return merge(left, right, bucket);
  }

  public static int[] merge(int[] left, int[] right, int[] bucket) {
    // this assumes left and right are ordered

    int l = 0;
    int r = 0;
    int current = 0;
    while (l < left.length && r < right.length) {
      if (left[l] < right[r]) {
        bucket[current] = left[l];
        l++;
      } else {
        bucket[current] = right[r];
        r++;
      }
      current++;
    }
    if (l != left.length) {
      return clone(bucket, left, current, l);
    } else if (r != right.length) {
      return clone(bucket, right, current, r);
    }
    return bucket;
  }

  public static int[] clone(int[] bucket, int[] from, int s1, int s2) {
    for (int i = s1, j = s2; i < bucket.length; i++, j++) {
      bucket[i] = from[j];
    }
    return bucket;
  }

  public static int[][] split(int[] items) {
    int mid = items.length / 2;
    return new int[][] { sublist(items, 0, mid), sublist(items, mid, items.length) };
  }

  public static int[] sublist(int[] items, int start, int end) {
    int[] sub = new int[end - start];
    for (int i = start, j = 0; i < end; i++, j++) {
      sub[j] = items[i];
    }
    return sub;
  }

  public static void main(String[] args) {
    int[] list = { 1, 2, 5, 4, 2, 3, 2 };
    // int[] list = { 3, 2, 4 };
    int[] sorted = sort(list);

    System.out.println(java.util.Arrays.toString(sorted));
  }
}
