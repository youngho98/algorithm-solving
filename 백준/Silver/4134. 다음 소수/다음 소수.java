import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            long n = sc.nextLong();
            if (n < 2) {
                System.out.println(2);
                continue;
            }
            while (true) {
                if (isPrime(n)) {
                    System.out.println(n);
                    break;
                } else {
                    n++;
                }
            }
        }
    }

    public static boolean isPrime(long n) {
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}