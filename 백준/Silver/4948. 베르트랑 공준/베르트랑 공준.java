import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 에라토스테네스의 체
        boolean[] isNotPrime = new boolean[246913];
        isNotPrime[0] = isNotPrime[1] = true;
        for (int i = 2; i < 497; i++) {
            if (isNotPrime[i]) {
                continue;
            }
            int n = i * 2;
            while (n < 246913) {
                isNotPrime[n] = true;
                n += i;
            }
        }

        // 입출력
        Scanner sc = new Scanner(System.in);
        while (true) {
            int cnt = 0;
            int n = sc.nextInt();
            if (n == 0) {
                break;
            }
            for (int i = n + 1; i <= n * 2; i++) {
                if (!isNotPrime[i]) {
                    cnt++;
                }
            }
            System.out.println(cnt);
        }
    }
}