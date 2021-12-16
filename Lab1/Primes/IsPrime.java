package Lab1.Primes;

public class IsPrime {
    public static void main(String[] args) {
        boolean flag = true;
        int n = Integer.parseInt(args[0]);
        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0) {
                flag = false;
                break;
            }
        }
        if (flag) {
            System.out.println(n + " is a prime number.");
        } else {
            System.out.println(n + " is a NOT prime number.");
        }
    }
}