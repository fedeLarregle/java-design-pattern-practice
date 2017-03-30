package producerConsumer;

import java.util.LinkedList;

/**
 * Created by federico on 29/03/17.
 */
public class Data {

    private LinkedList<Integer> list = new LinkedList<>();
    private final int capacity = 4;

    public void produce() throws InterruptedException {
        int value = 0;

        while ( true ) {

            synchronized (this) {
                /* We make the producer thread wait while the linkedlist is full */
                while ( list.size() == capacity ) {
                    wait();
                }

                System.out.println("Producer just produced value: " + value);

                list.add(value++);
                /* Notifies to the consumer that now the linkedlist has data to consume */
                notify();

            }
        }
    }

    public void consume() throws InterruptedException {

        while ( true ) {

            synchronized (this) {
                /* We make the Consumer thread wait while there's no data to consume in the linkedlist */
                while (list.size() == 0) {
                    wait();
                }
                /* Value to be consumed */
                int value = list.removeFirst();

                System.out.println("Consumer just consumed value: " + value);
                /* Notify the Producer thread that we just consumed a value and that he can start producing again */
                notify();
            }
        }
    }
}
