import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int h = sc.nextInt();
            int w = sc.nextInt();
            int n = sc.nextInt();
            if (n % h != 0) {
                System.out.printf("%d%02d%n", n % h, n / h + 1);
            } else {
                System.out.printf("%d%02d%n", h, n / h);
            }
        }
    }
}