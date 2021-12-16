package Lab1.Primes;

public class PrimeLessThan {
    public static void main(String[] args) {
        boolean flag = true;
        int n = Integer.parseInt(args[0]);
        for (int j = 2; j < n; j++) {
            flag = true;
            for (int i = 2; i <= j / 2; i++) {
                if (j % i == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                System.out.println(j + " is a prime number.");
            } else {
                // System.out.println(j + " is a NOT prime number.");
            }
        }
    }
}
