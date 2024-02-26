import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int e = sc.nextInt() % 15;
        int s = sc.nextInt() % 28;
        int m = sc.nextInt() % 19;
        int i = 1;
        while (true) {
            if (i % 15 == e && i % 28 == s && i % 19 == m) {
                System.out.println(i);
                break;
            }
            i++;
        }
    }
}