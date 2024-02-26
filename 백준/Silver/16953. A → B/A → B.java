import java.util.Scanner;

public class Main {
    static int b, min;
    static boolean possible = false;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        b = sc.nextInt();
        min = Integer.MAX_VALUE;

        calc(a, 1);

        if (possible) {
            System.out.println(min);
        } else {
            System.out.println(-1);
        }
    }
    static void calc(long a, int cnt) {
        if (a == b) {
            if (cnt < min) {
                min = cnt;
            }
            possible = true;
            return;
        } else if (a > b) {
            return;
        }
        calc(a * 2, cnt + 1);
        calc(a * 10 + 1, cnt + 1);
    }
}