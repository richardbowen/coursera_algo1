import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;

public class RandomizedQueue<Item> implements Iterable<Item> {

    private final Deque<Item> deque = new Deque<>();

    // construct an empty randomized queue
    public RandomizedQueue() {

    }

    // is the randomized queue empty?
    public boolean isEmpty() {
        return deque.isEmpty();
    }

    // return the number of items on the randomized queue
    public int size() {
        return deque.size();
    }

    // add the item
    public void enqueue(Item item) {
        if (StdRandom.bernoulli())
            deque.addFirst(item);
        else
            deque.addLast(item);
    }

    // remove and return a random item
    public Item dequeue() {
        return deque.removeFirst();
    }

    // return a random item (but do not remove it)
    public Item sample() {
        return deque.peekFirst();
    }

    // return an independent iterator over items in random order
    public Iterator<Item> iterator() {
        return deque.iterator();
    }

    // unit testing (required)
    public static void main(String[] args) {
        RandomizedQueue<String> rq = new RandomizedQueue<>();
        rq.enqueue("test");
        rq.dequeue();
    }

}
