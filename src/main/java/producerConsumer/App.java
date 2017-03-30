package producerConsumer;

/**
 * Created by federico on 29/03/17.
 */
public class App {

    public static void main(String... args) throws InterruptedException {

        final Data data = new Data();
        /* Creating the producer thread */
        Thread producer = new Thread( () -> {
            try {
                data.produce();
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
        });
        /* Creating the consumer thread */
        Thread consumer = new Thread( () -> {
            try {
                data.consume();
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
        });
        /* Starting both threads */
        producer.start();
        consumer.start();
        /* We tell the main thread to wait for the producer and consumer threads to finish, first finishing the producer */
        try {
            producer.join();
            consumer.join();
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
    }
}
