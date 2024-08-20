
class SharedResource {
    private int number;
    private boolean isProduced = false;

    // Producer thread
    public synchronized void produce(int number) {
        while (isProduced) {
            try {
                wait();  // Wait if the number has already been produced
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.number = number;
        System.out.println("Produced: " + number);
        isProduced = true;
        notify();  // Notify the consumer thread that the number has been produced
    }

    // Consumer thread
    public synchronized void consume() {
        while (!isProduced) {
            try {
                wait();  // Wait if the number has not been produced yet
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Consumed: " + number);
        isProduced = false;
        notify();  // Notify the producer thread that the number has been consumed
    }
}

class Producer extends Thread {
    private SharedResource resource;

    public Producer(SharedResource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            resource.produce(i);
        }
    }
}

class Consumer extends Thread {
    private SharedResource resource;

    public Consumer(SharedResource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            resource.consume();
        }
    }
}

public class InterThreadCommunicationExample {
    public static void main(String[] args) {
        SharedResource resource = new SharedResource();

        Producer producer = new Producer(resource);
        Consumer consumer = new Consumer(resource);

        producer.start();
        consumer.start();
    }
}
