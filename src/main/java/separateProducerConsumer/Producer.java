package separateProducerConsumer;

import java.util.LinkedList;

/**
 * Created by federico on 30/03/17.
 */
public class Producer {

    /* Both Consumer and Producer threads are going to use the same key Object as a Lock */
    private final Object key;
    private LinkedList<Integer> buffer;
    /* We set from the main app a final capacity in order to be able to 'fill in' the Linkedlist at some point */
    private final int capacity;
    private int counter;

    public Producer(LinkedList<Integer> buffer, final int capacity, final Object key) {
        this.buffer = buffer;
        this.capacity = capacity;
        this.key = key;
        this.counter = 0;
    }

    public void produce() throws InterruptedException {

        while ( true ) {

            synchronized (key) {
                /* We tell the producer thread to wait if there's no space to produce another item */
                while ( isFull(buffer) ) {
                    key.wait();
                }

                System.out.println("Producer produced: " + counter);
                buffer.add(counter++);
                /* We notify to the consumer thread that there's an item to consume */
                key.notify();
            }
        }
    }

    /* Helper method to see if the LinkedlList is full */
    private boolean isFull(LinkedList<Integer> buffer) {
        return buffer.size() == capacity;
    }
}
