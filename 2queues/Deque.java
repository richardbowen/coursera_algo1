import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

class DequeIterator<Item> implements Iterator<Item> {

    public DequeIterator(Deque<Item> d){

    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public Item next() {
        return null;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void forEachRemaining(Consumer<? super Item> action) {

    }
}


public class Deque<Item> implements Iterable<Item> {

    // construct an empty deque
    public Deque(){

    }

    // is the deque empty?
    public boolean isEmpty(){
        return true;
    }

    // return the number of items on the deque
    public int size(){
        return 0;
    }

    // add the item to the front
    public void addFirst(Item item){
        if (item==null)
            throw new IllegalArgumentException();
    }

    // add the item to the back
    public void addLast(Item item){
        if (item==null)
            throw new IllegalArgumentException();
    }

    // remove and return the item from the front
    public Item removeFirst(){
        if (isEmpty())
            throw new NoSuchElementException();

        return null;
    }

    // remove and return the item from the back
    public Item removeLast(){
        if (isEmpty())
            throw new NoSuchElementException();

        return null;
    }

    // return an iterator over items in order from front to back
    public Iterator<Item> iterator(){
        return new DequeIterator<>(this);
    }


    // unit testing (required)
    public static void main(String[] args){

    }

}
