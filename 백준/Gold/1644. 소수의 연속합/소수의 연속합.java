import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        // 에라토스테네스의 체
        Deque<Integer> primes = new ArrayDeque<>();
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                primes.offerLast(i);
                int num = i * 2;
                while (num <= n) {
                    isPrime[num] = false;
                    num += i;
                }
            }
        }

        // 투포인터 판별
        Iterator<Integer> it = primes.iterator();
        int sum = 0;
        int cnt = 0;
        while (it.hasNext()) {
            if (sum < n) {
                sum += it.next();
            } else if (sum > n) {
                sum -= primes.pollFirst();
            } else {
                cnt++;
                sum += it.next();
            }
        }
        while (sum >= n) {
            if (sum == n) {
                cnt++;
            }
            sum -= primes.pollFirst();
        }

        System.out.println(cnt);
    }
}
