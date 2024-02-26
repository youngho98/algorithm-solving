import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] cnt = new int[10];
        while (n >= 10) {
            cnt[n % 10]++;
            n /= 10;
        }
        cnt[n]++;

        for (int i = 9; i >= 0; i--) {
            for (int j = 0; j < cnt[i]; j++) {
                System.out.print(i);
            }
        }
    }
}