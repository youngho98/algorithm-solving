import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();
        int e = sc.nextInt();
        int f = sc.nextInt();
        if (a == c) {
            System.out.print(e + " ");
        } else if (a == e) {
            System.out.print(c + " ");
        } else {
            System.out.print(a + " ");
        }
        if (b == d) {
            System.out.println(f);
        } else if (b == f) {
            System.out.println(d);
        } else {
            System.out.println(b);
        }
    }
}