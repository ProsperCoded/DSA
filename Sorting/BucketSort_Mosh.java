package Sorting;

import java.util.ArrayList;
import java.util.List;

public class BucketSort_Mosh {
  public void sort(int[] array, int numberOfBuckets) {
    List<Integer> x = new ArrayList<>();
    // list of list
    List<List<Integer>> buckets = new ArrayList<>();
    for (int i = 0; i < numberOfBuckets; i++) {
      buckets.add(new ArrayList<>());
    }

    for (var item : array) {
      buckets.get(item / numberOfBuckets).add(item);
    }

    for (var bucket : buckets) {
      java.util.Collections.sort(bucket); // implementation of quick sort
      for (var item : bucket) {
        x.add(item);
      }
    }

  }
}
