import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int f = Integer.parseInt(br.readLine());

        n /= 100;
        n *= 100;
        int ans = 0;
        for (int i = 0; i < 100; i++) {
            if ((n + i) % f == 0) {
                ans = i;
                break;
            }
        }

        if (ans < 10) {
            System.out.println("0" + ans);
        } else {
            System.out.println(ans);
        }
    }
}