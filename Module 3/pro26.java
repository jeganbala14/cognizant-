class MessageThread extends Thread {
    private String message;

    public MessageThread(String message) {
        this.message = message;
    }

    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(message + " - Count: " + (i + 1));
            try {
                Thread.sleep(500); // Sleep to better observe interleaving
            } catch (InterruptedException e) {
                // Handle exception
            }
        }
    }
}

public class pro26 {
    public static void main(String[] args) {
        MessageThread t1 = new MessageThread("Thread 1 running");
        MessageThread t2 = new MessageThread("Thread 2 running");

        t1.start();
        t2.start();
    }
}
