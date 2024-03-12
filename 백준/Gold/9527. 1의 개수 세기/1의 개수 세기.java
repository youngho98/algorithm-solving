import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        System.out.println(calc(b) - calc(a - 1));
    }

    static long power2(long n) {
        return (1L << (n - 1)) * n + 1;
    }

    static long calc(long n) {
        long cnt = 0;
        for (int i = 53; i >= 0; i--) {
            if (n >= (1L << i)) {
                cnt += power2(i);
                n -= 1L << i;
                cnt += n;
            }
        }
        return cnt;
    }
}