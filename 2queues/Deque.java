import java.util.Iterator;
import java.util.NoSuchElementException;


public class Deque<Item> implements Iterable<Item> {

    private DNode<Item> head = null;
    private DNode<Item> tail = null;
    private int count = 0;

    // construct an empty deque
    public Deque() {

    }

    private class DNode<NodeT> {
        private final NodeT val;
        private DNode<NodeT> next = null;
        private DNode<NodeT> prev = null;

        public DNode(NodeT item) {
            this.val = item;
        }
    }

    private class DequeIterator<ItemIt> implements Iterator<ItemIt> {

        private Deque<ItemIt>.DNode<ItemIt> next;

        private  DequeIterator(Deque<ItemIt> d) {
            next = d.head;
        }

        @Override
        public boolean hasNext() {
            return next != null;
        }


        @Override
        public ItemIt next() {
            if (next==null)
                throw new NoSuchElementException();
            Deque<ItemIt>.DNode<ItemIt> result = next;
            next = next.next;
            return result.val;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

    }

    // is the deque empty?
    public boolean isEmpty() {
        return this.head == null;
    }

    // return the number of items on the deque
    public int size() {
        return this.count;
    }

    // add the item to the front
    public void addFirst(Item item) {
        if (item == null)
            throw new IllegalArgumentException();

        count += 1;
        DNode<Item> old = this.head;
        this.head = new DNode<>(item);
        if (this.tail == null)
            this.tail = this.head;
        else {
            this.head.next = old;
            old.prev = this.head;
        }
    }

    // add the item to the back
    public void addLast(Item item) {
        if (item == null)
            throw new IllegalArgumentException();

        count += 1;
        DNode<Item> old = this.tail;
        this.tail = new DNode<>(item);
        if (old == null) {
            this.head = this.tail;
        } else {
            old.next = this.tail;
            this.tail.prev = old;
        }
    }

    // remove and return the item from the front
    public Item removeFirst() {
        if (isEmpty())
            throw new NoSuchElementException();

        DNode<Item> result = this.head;
        this.head = result.next;
        if (result.next == null) {
            this.tail = null;
        } else {
            result.next.prev = null;
        }

        count -= 1;
        return result.val;
    }

    // remove and return the item from the back
    public Item removeLast() {
        if (isEmpty())
            throw new NoSuchElementException();

        DNode<Item> result = this.tail;
        if (this.tail.prev == null) {
            this.tail = null;
            this.head = null;
        } else {
            this.tail = this.tail.prev;
            this.tail.next = null;
        }

        count -= 1;
        return result.val;
    }

    // return an iterator over items in order from front to back
    public Iterator<Item> iterator() {
        return new DequeIterator<>(this);
    }


    // unit testing (required)
    public static void main(String[] args) {
        Deque<String> d = new Deque<>();
//        d.addFirst("a");
//        d.addFirst("c");
//
//        String o = d.removeLast();
//        String o2 = d.removeLast();

    }

}
