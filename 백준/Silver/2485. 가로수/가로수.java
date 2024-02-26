import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int[] dist = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            dist[i] = arr[i + 1] - arr[i];
        }

        int gcd = dist[0];
        for (int i : dist) {
            gcd = gcd(gcd, i);
        }

        System.out.println((arr[n - 1] - arr[0]) / gcd - n + 1);
    }

    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}