import java.util.Random;

public class RepeatCount extends Thread {
    private static final int ARRAY_SIZE = 100000;
    private static final int NUM_THREADS = 1;
    private static final int CHUNK_SIZE = ARRAY_SIZE / NUM_THREADS;
    private static int KEY;

    private int startIndex, endIndex;
    private static int myArray[];
    private static RepeatCount myThreads[];

    private boolean flag;
    private String threadName;
    public static Random randomGenerator = new Random();
    public int c;

    public RepeatCount(int startIndex, int endIndex, String threadName) {
        this.startIndex = startIndex;
        this.endIndex = endIndex;
        this.threadName = threadName;
        this.c = 0;
    }

    @Override
    public void run() {
        for (int i = startIndex; i <= endIndex; i++) {
            if (KEY == myArray[i]) {
                System.out.println("Search is successful by " + threadName);
                flag = true;
                c += 1;
            }
        }
        if (flag == false) {
            System.out.println("Search is unsuccessful by " + threadName);
        }
    }

    public static void main(String[] args) {
        int count_total = 0;
        myArray = new int[ARRAY_SIZE];
        myThreads = new RepeatCount[NUM_THREADS];

        for (int i = 0; i < ARRAY_SIZE; i++) {
            myArray[i] = randomGenerator.nextInt();
        }
        KEY = myArray[randomGenerator.nextInt(ARRAY_SIZE)];
        long start = System.nanoTime();

        for (int i = 0; i < NUM_THREADS; i++) {
            myThreads[i] = new RepeatCount(CHUNK_SIZE * i, (CHUNK_SIZE * (i + 1)) - 1,
                    "Thread " + Integer.toString(i + 1));
            myThreads[i].start();
        }
        for (int i = 0; i < NUM_THREADS; i++) {
            try {
                myThreads[i].join();
                count_total += myThreads[i].c;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("The total count is " + count_total);
        long end = System.nanoTime();

        System.out.println("Time Taken: " + String.valueOf(end - start) + " nanoseconds");

    }
}