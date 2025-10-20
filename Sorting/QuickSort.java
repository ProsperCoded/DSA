package Sorting;

// a sort used in most programming lanbuages 

// you select a pivot, either a specific index or a randomized item 

// pivot selection 
// Pick randomly
// use the middle index
// average of first middle and last item 

public class QuickSort {
  public static void sort(int[] items, int current, int pivot) {
    if (current >= pivot) {
      return;
    }
    int boundary = current - 1;
    int start = current;
    int end = pivot;
    // int current = 0;

    while (current < pivot) {
      if (items[current] < items[pivot]) {
        // move current into left patition
        // if not next to each other just swap
        if (current > boundary + 1) {
          int temp = items[current];
          items[current] = items[boundary + 1];
          items[boundary + 1] = temp;
        }
        boundary++;
      }
      current++;
    }
    // last swap (check if pivot is two elements ahead boundary)
    if (boundary + 1 < pivot) {
      // swap
      int temp = items[boundary + 1];
      items[boundary + 1] = items[pivot];
      items[pivot] = temp;
    }
    // boundary++;
    pivot = boundary;
    // sort left
    sort(items, start, pivot);
    // sort right
    sort(items, pivot + 1, end);

  }

  public static int getPivot(int[] items) {

    return items.length - 1;

  }

  public static void main(String[] args) {
    int[] list = { 2, 1, 4, 5, 3, 1, 3, 22 };
    // int[] list = { 3, 2, 4 };
    sort(list, 0, list.length - 1);

    System.out.println(java.util.Arrays.toString(list));
  }
}
