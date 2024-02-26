import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();
        int up = a * d + b * c;
        int down = b * d;
        System.out.println(up / gcd(up, down) + " " + down / gcd(up, down));
    }

    public static int gcd(int a, int b) {
        while (a % b > 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return b;
    }
}