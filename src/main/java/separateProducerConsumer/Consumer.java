package separateProducerConsumer;

import java.util.LinkedList;

/**
 * Created by federico on 30/03/17.
 */
public class Consumer {

    private LinkedList<Integer> buffer;
    /* Both Consumer and Producer threads are going to use the same key Object as a Lock */
    private final Object key;

    public Consumer(LinkedList<Integer> buffer, final Object key) {
        this.buffer = buffer;
        this.key = key;
    }

    public void consume() throws InterruptedException {

        while ( true ) {

            synchronized (key) {
                /* While empty we tell the consumer thread to wait until there's something to consume.. */
                while ( isEmpty(buffer) ) {
                    key.wait();
                }

                System.out.println("Consumer consumed: " + buffer.removeFirst());
                /* After we consume we tell the producer thread that there's 'space' again to produce */
                key.notify();
            }
        }
    }

    /* Helper method to see if there's no items to consume */
    private boolean isEmpty(LinkedList<Integer> buffer) {
        return buffer.size() == 0;
    }
}
