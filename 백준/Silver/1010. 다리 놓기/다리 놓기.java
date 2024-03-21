import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            System.out.println(combination(b, a));
        }
    }

    static int combination(int a, int b) {
        int result = 1;
        for (int i = 0; i < b; i++) {
            result *= (a - i);
            result /= (i + 1);
        }
        return result;
    }
}