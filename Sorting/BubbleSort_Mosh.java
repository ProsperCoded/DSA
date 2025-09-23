package Sorting;

public class BubbleSort_Mosh {
  public void sort(int[] array) {
    boolean isSorted = true;
    for (int i = 0; i < array.length; i++) {
      for (int j = 0; j < array.length - i; j++) {
        // swap if the current element is smaller than the previous element
        if (j > 0 && array[j] < array[j - 1]) {
          var temp = array[j];
          array[j] = array[j - 1];
          array[j - 1] = temp;
          isSorted = false;
        }
      }
      if (isSorted)
        break;
    }
  }
}
