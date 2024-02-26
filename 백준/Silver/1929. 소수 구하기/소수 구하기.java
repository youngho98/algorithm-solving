import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");
        int m = Integer.parseInt(arr[0]), n = Integer.parseInt(arr[1]);
        // 소수가 아닌 수 집합
        HashSet<Integer> notPrime = new HashSet<>();
        notPrime.add(1);
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (!notPrime.contains(i)) {
                int k = 2 * i;
                while (k <= n) {
                    notPrime.add(k);
                    k += i;
                }
            }
        }
        // 소수만 출력
        for (int i = m; i <= n; i++) {
            if (!notPrime.contains(i)) {
                System.out.println(i);
            }
        }
    }
}