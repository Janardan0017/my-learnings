package javadeepdown.collections;

import java.util.PriorityQueue;
import java.util.Queue;


// Queue Interface
// Extends the Collection interface.
// Represents a collection designed for holding elements prior to processing.
// Common implementing classes include LinkedList (can function as a queue) and PriorityQueue.
// Structure
// Action	Throws exception	Returns special value
// Insert	add(e)	offer(e)
// Remove	remove()	poll()
// Examine	element()	peek()
public class QueueDemo {

    public static void main(String[] args) {
        Queue q = new PriorityQueue<Integer>();
        q.add("1");
        System.out.println(q);
    }

}
