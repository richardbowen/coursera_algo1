import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {

    private final Deque<Item> deque = new Deque<>();

    // construct an empty randomized queue
    public RandomizedQueue() {

    }

    private class RandomizedQueueIterator<ItemIt> implements Iterator<ItemIt> {

        ItemIt[] vals;
        int idx = 0;

        private RandomizedQueueIterator(Deque<ItemIt> dq) {
            vals = (ItemIt[]) new Object[dq.size()];
            int i = 0;
            for (ItemIt it : dq)
                vals[i++] = it;
            StdRandom.shuffle(vals);
        }

        @Override
        public boolean hasNext() {
            return idx < vals.length;
        }

        @Override
        public ItemIt next() {
            if (!hasNext())
                throw new NoSuchElementException();

            return vals[idx++];
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
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
        return deque.iterator().next();
    }

    // return an independent iterator over items in random order
    public Iterator<Item> iterator() {
        return new RandomizedQueueIterator<>(deque);
    }

    // unit testing (required)
    public static void main(String[] args) {
        RandomizedQueue<String> rq = new RandomizedQueue<>();
        rq.enqueue("aa");
        rq.enqueue("bb");

        for (String s : rq)
            System.out.println(s);

        rq.dequeue();
    }

}
