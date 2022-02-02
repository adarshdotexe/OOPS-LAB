import java.util.Random;

class PrimeNumberisGenerated extends Exception {

    public PrimeNumberisGenerated() {
        super();
    }
}
  
class Primes {
  
    static boolean isPrime(int n)
    {
        if (n <= 1)
            return false;
        if (n <= 3)
            return true;
        if (n % 2 == 0 || n % 3 == 0)
            return false;
  
        for (int i = 5; i * i <= n; i = i + 6)
            if (n % i == 0 || n % (i + 2) == 0)
                return false;
  
        return true;
    }  
    public static void main(String args[])
    {
        Random r = new Random();
        int arr[] = new int[500];
        String s = "";
        for (int i = 0; i < 500; i++) {
            int x = r.nextInt();
            try {
                if(isPrime(x)){
                    throw new PrimeNumberisGenerated();
                }
            } catch (Exception e) {
                s+=" " + Integer.toString(i);
                x+=1;
            }
            arr[i] = x;
        }
        for (int i = 0; i < 499; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println(arr[499]);
        System.out.println("Exceptions Raised at: " + s);

    }
}