package separateProducerConsumer;

import java.util.LinkedList;

/**
 * Created by federico on 30/03/17.
 */
public class App {

    public static void main(String... args) {

        LinkedList<Integer> buffer = new LinkedList<>();
        /* lock Object that we are going to use to synchronize our two producer and consumer threads */
        final Object key = new Object();
        /* Creating a fix capacity for the buffer */
        final int capacity = 5;

        Producer producer = new Producer(buffer, capacity, key);
        Consumer consumer = new Consumer(buffer, key);

        Thread producerThread = new Thread( () -> {
            try {
                producer.produce();
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
        });

        Thread consumerThread = new Thread( () -> {
            try {
                consumer.consume();
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
        });


        producerThread.start();
        consumerThread.start();

        /*
        * We tell the main thread to wait for both threads (producer and consumer) to finish
        * and more precisely we're going to wait for the producerThread to finish and then
        * we're going to wait for the consumerThread to finish before going back to the main thread
        */
        try {
            producerThread.join();
            consumerThread.join();
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
    }
}
