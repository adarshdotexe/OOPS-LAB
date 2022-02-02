import java.util.Random;

public class LinearSearchMulti extends Thread {
    private static final int ARRAY_SIZE = 100000;
    private static final int NUM_THREADS = 4;
    private static final int CHUNK_SIZE = ARRAY_SIZE / NUM_THREADS;
    private static final int KEY = 10;

    private int startIndex, endIndex;
    private static int myArray[];
    private static Thread myThreads[];

    private boolean flag;
    private String threadName;
    public static Random randomGenerator = new Random();

    public LinearSearchMulti(int startIndex, int endIndex, String threadName) {
        this.startIndex = startIndex;
        this.endIndex = endIndex;
        this.threadName = threadName;
    }

    @Override
    public void run() {
        for (int i = startIndex; i <= endIndex; i++) {
            if (KEY == myArray[i]) {
                System.out.println("Search is successful by " + threadName);
                flag = true;
                return;
            }
        }
        if (flag == false) {
            System.out.println("Search is unsuccessful by " + threadName);
        }
    }

    public static void main(String[] args) {

        myArray = new int[ARRAY_SIZE];
        myThreads = new Thread[NUM_THREADS];

        for (int i = 0; i < ARRAY_SIZE; i++) {
            myArray[i] = randomGenerator.nextInt();
        }
        long start = System.nanoTime();

        for (int i = 0; i < NUM_THREADS; i++) {
            myThreads[i] = new LinearSearchMulti(CHUNK_SIZE * i, (CHUNK_SIZE * (i + 1)) - 1,
                    "Thread " + Integer.toString(i + 1));
            myThreads[i].start();
        }
        for (int i = 0; i < NUM_THREADS; i++) {
            try {
                myThreads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        long end = System.nanoTime();

        System.out.println("Time Taken: " + String.valueOf(end - start) + " nanoseconds");

    }
}