import java.util.Scanner;

public class P2 {

    static Scanner sc;
    static int num;

    class User extends Thread {
        int tot_guess;

        User(String s) {
            setName(s);
            tot_guess = 0;
        }

        @Override
        public void run() {
            int x;
            while (tot_guess < 6) {
                synchronized (sc) {
                    System.out.println("Player " + getName() + " Make a guess.");
                    x = sc.nextInt();
                }
                if (x == num) {
                    System.out.println("Player " + getName() + " Wins.");
                    break;
                } else if (x > num) {
                    System.out.println("Lower!");
                } else {
                    System.out.println("Higher!");
                }
                tot_guess++;
            }
        }
    }

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        num = (int) ((Math.random() * 91) + 10);
        P2 a = new P2();
        User one = a.new User("adarsh");
        User two = a.new User("mohan");
        User three = a.new User("adithya");
        one.start();
        two.start();
        three.start();
        try {
            one.join();
            two.join();
            three.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        sc.close();

    }

}
