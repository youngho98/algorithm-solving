import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int max = Math.max(Math.max(a, b), c);
        int l = Math.min(a + b + c - max - 1, max);
        System.out.println(l + a + b + c - max);
    }
}