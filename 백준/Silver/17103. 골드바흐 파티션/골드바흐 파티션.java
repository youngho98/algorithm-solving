import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 에라토스테네스의 체
        boolean[] isNotPrime = new boolean[1_000_001];
        isNotPrime[0] = isNotPrime[1] = true;
        for (int i = 2; i <= 1000; i++) {
            if (isNotPrime[i]) {
                continue;
            }
            int n = i * 2;
            while (n < 1_000_001) {
                isNotPrime[n] = true;
                n += i;
            }
        }

        // 입출력
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int num = sc.nextInt();
            int cnt = 0;
            for (int j = 2; j <= num / 2; j++) {
                if (isNotPrime[j] || isNotPrime[num - j]) {
                    continue;
                }
                cnt++;
            }
            System.out.println(cnt);
        }
    }
}