
class player extends Thread {
    int z;

    player(String s) {
        setName(s);
        z = 0;
    }

    public void run() {

        for (int i = 0; i < 6; i++) {

            synchronized (this) {

                int x = (int) (Math.random() * 91) + 10;

                int y = (int) (Math.random() * 91) + 10;

                if (y == x) {
                    System.out.println("Player " + this.getName() + " wins.");
                    this.z=this.z+1;
                }
            }
        }

    }
}

public class P1 {
    public static void main(String[] args) {

        player one = new player("one");
        player two = new player("two");
        player three = new player("three");
        one.start();
        two.start();
        three.start();
        while(one.isAlive()){}
        while(two.isAlive()){}
        while(three.isAlive()){}
        System.out.println("Player one won " + one.z + " Times.");
        System.out.println("Player two won " + two.z + " Times.");
        System.out.println("Player three won " + three.z + " Times.");


    }

}
