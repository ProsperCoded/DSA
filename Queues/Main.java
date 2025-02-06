package Queues;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
  public static void main(String[] args){
    // Queue<Integer> queue  = new ArrayDeque<>();
    // queue.add(10);
    // queue.add(10);
    // queue.add(20);
    // queue.add(30);
    // queue.add(40);
    // var value = reverse(queue);
    // System.out.println(value.toString());

    var queue = new CircularArray(3);
    queue.enqueue(3);
    queue.enqueue(4);
    queue.enqueue(2);
    
    queue.dequeue();
    queue.dequeue();
    queue.dequeue();

    queue.enqueue(1);
    queue.enqueue(2);
    queue.enqueue(3);
    System.out.println(queue.toString());
  }
  public static LinkedList reverse(Queue<Integer> queue){
    LinkedList<Integer> store = new LinkedList<Integer>();
    while (!queue.isEmpty()) {
      var element = queue.remove();
      store.addFirst(element);
    }
    return store;
  }
}
