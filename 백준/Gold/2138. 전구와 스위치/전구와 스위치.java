import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static boolean[] bulb1, bulb2;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        char[] ch1 = br.readLine().toCharArray();
        char[] ch2 = br.readLine().toCharArray();

        // 전구 입력
        bulb1 = new boolean[n];
        bulb2 = new boolean[n];
        boolean[] goal = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (ch1[i] == '1') {
                bulb1[i] = true;
                bulb2[i] = true;
            }
            if (ch2[i] == '1') {
                goal[i] = true;
            }
        }

        // case 1 (bulb1)
        press(0, bulb1);
        int cnt1 = 1;
        for (int i = 1; i < n; i++) {
            if (bulb1[i - 1] != goal[i - 1]) {
                press(i, bulb1);
                cnt1++;
            }
        }
        if (!check(bulb1, goal)) {
            cnt1 = 1_000_000;
        }

        // case 2 (bulb2)
        int cnt2 = 0;
        for (int i = 1; i < n; i++) {
            if (bulb2[i - 1] != goal[i - 1]) {
                press(i, bulb2);
                cnt2++;
            }
        }
        if (!check(bulb2, goal)) {
            cnt2 = 1_000_000;
        }

        int ans = Math.min(cnt1, cnt2);

        if (ans == 1_000_000) {
            System.out.println(-1);
        } else {
            System.out.println(ans);
        }
    }

    static void press(int k, boolean[] bulb) {
        if (k == 0) {
            bulb[0] = !bulb[0];
            bulb[1] = !bulb[1];
        } else if (k == n - 1) {
            bulb[n - 2] = !bulb[n - 2];
            bulb[n - 1] = !bulb[n - 1];
        } else {
            bulb[k - 1] = !bulb[k - 1];
            bulb[k] = !bulb[k];
            bulb[k + 1] = !bulb[k + 1];
        }
    }

    static boolean check(boolean[] bulb, boolean[] goal) {
        for (int i = 0; i < n; i++) {
            if (bulb[i] != goal[i]) {
                return false;
            }
        }
        return true;
    }
}