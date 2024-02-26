import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int n3 = a * (b % 10);
        int n4 = a * ((b % 100) / 10);
        int n5 = a * (b / 100);
        int n6 = n3 + n4 * 10 + n5 * 100;
        System.out.println(n3);
        System.out.println(n4);
        System.out.println(n5);
        System.out.println(n6);
    }
}