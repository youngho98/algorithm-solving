import java.util.Scanner;

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println((int) Math.pow(2, n) - 1);
        hanoi(n, 1, 3, 2);
        System.out.println(sb);
    }

    static void hanoi(int num, int a, int b, int r) {
        if (num == 0) {
            return;
        }
        hanoi(num - 1, a, r, b);
        sb.append(a + " " + b + "\n");
        hanoi(num -1, r, b, a);
    }
}