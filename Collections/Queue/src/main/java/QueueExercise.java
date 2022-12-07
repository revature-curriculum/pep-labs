/**
 * TODO: switch to deque
 */

import java.util.Queue;

/**
 * Queues are FIFO - first in, first out, like a checkout line. They are used in algorithms where it is needed to keep
 * track of the order that the elements were inserted in. For instance, tech support tickets may be
 * waiting in a queue until a tech support specialist can clear them.
 *
 * ArrayDeque fills the role of *both* queues and stacks. You could think of a Deque as a deck of cards (pronounced the
 * same) where you could remove cards  from either the top or bottom. You can use ArrayDeque
 * to perform queue operations. You can read about ArrayDeque in the official Javadocs here:
 * https://docs.oracle.com/javase/7/docs/api/java/util/ArrayDeque.html
 * And you can read about the queue interface here:
 * https://docs.oracle.com/javase/8/docs/api/java/util/Queue.html
 * Notice that ArrayDeque implements multiple interfaces, including Queue!
 *
 * PriorityQueue is another implementation of Queue that has additional functionality
 * to handle multiple 'priorities' of items. You can read about PriorityQueue here:
 * https://www.geeksforgeeks.org/priority-queue-class-in-java/
 */
public class QueueExercise {
    /**
     * Instantiate and return some type of Queue.
     * @return an instantiated Queue. Queue, by itself, doesn't have a class, so you should use a class that
     * implements the Queue interface, such as ArrayDeque. Deques contain all the methods required for both Queue and
     * Stack behavior.
     */
    public Queue<String> createQueue(){
        return null;
    }

    /**
     * Return the ssize of a queue.
     * @param queue a Queue<String> object.
     * @return the length of queue.
     */
    public int getSize(Queue<String> queue){
        return 0;
    }

    /**
     * Add an item to the end of the queue - the queue will be able to return to that item once all the items
     * in front of it have been removed.
     * @param queue a Queue<String> object.
     * @param item a String that should be added to Queue.
     */
    public void addToEndOfQueue(Queue<String> queue, String item){

    }

    /**
     * Remove an item from a queue, and return the removed item.
     * (The method used to remove items from queues also returns the item.)
     * @param queue a Queue<String> object.
     * @return the next String due to be removed (polled) from the Queue<String> (the oldest item in the queue.)
     */
    public String removeFromStartOfQueue(Queue<String> queue){
        return "";
    }

    /**
     * Return the next item from a queue which is due to be removed, but do not remove it.
     * @param queue a Queue<String> object.
     * @return the next String due to be removed (peeked) from the Queue<String> (the oldest item in the queue.)
     */
    public String getStartOfQueueWithoutRemoving(Queue<String> queue){
        return "";
    }
}
