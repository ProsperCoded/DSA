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

    while (current < pivot) {
      // if less than pivote move current into left patition
      if (items[current] < items[pivot]) {
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
    pivot = boundary + 1;
    // sort left
    sort(items, start, pivot - 1);
    // sort right
    sort(items, pivot + 1, end);
  }

  public static void main(String[] args) {
    int[] list = { 2, 1, 4, 5, 3, 1, 3, 22 };
    // int[] list = { 3, 2, 4 };
    sort(list, 0, list.length - 1);

    System.out.println(java.util.Arrays.toString(list));
  }
}
