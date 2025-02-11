package Queues;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
  public static void main(String[] args){

    var queue = new PriorityQueue(5);
    queue.insert(4);
    queue.insert(3);
    queue.insert(1);
    queue.insert(2);
    queue.insert(7);
    queue.insert(6);
    queue.insert(6);
    queue.insert(5);
    // queue.insert(3);
    System.out.println(queue.toString());
  }
  public static LinkedList<Integer> reverse(Queue<Integer> queue){
    LinkedList<Integer> store = new LinkedList<Integer>();
    while (!queue.isEmpty()) {
      var element = queue.remove();
      store.addFirst(element);
    }
    return store;
  }
}
