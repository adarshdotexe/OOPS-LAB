public class RandomWalkers {

    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        int T = Integer.parseInt(args[1]);
        double sum = 0;
        for (int i = 0; i < T; i++) {
            sum += RandomWalker(N);
        }
        System.out.println("mean squared distance = " + sum / T);
    }

    public static int RandomWalker(int n) {
        int x = 0, y = 0;
        for (int i = 0; i < n; i++) {
            double rand = Math.random();
            if (rand < 0.25)
                ++x;
            else if (rand < 0.5)
                --y;
            else if (rand < 0.75)
                --x;
            else if (rand < 1.0)
                ++y;
        }
        return x * x + y * y;
    }

}