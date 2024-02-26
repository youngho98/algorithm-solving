import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int result = a * b * c;

        int[] cnt = new int[10];
        while (result >= 10) {
            cnt[result % 10]++;
            result /= 10;
        }
        cnt[result]++;

        for (int i : cnt) {
            System.out.println(i);
        }
    }
}