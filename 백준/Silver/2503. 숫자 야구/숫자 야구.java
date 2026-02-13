import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        BaseBall[] baseBalls = new BaseBall[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char[] num = st.nextToken().toCharArray();
            int strike = Integer.parseInt(st.nextToken());
            int ball = Integer.parseInt(st.nextToken());
            baseBalls[i] = new BaseBall(num, strike, ball);
        }

        int cnt = 0;
        for (char i = '1'; i <= '9'; i++) {
            for (char j = '1'; j <= '9'; j++) {
                if (i == j) continue;
                for (char k = '1'; k <= '9'; k++) {
                    if (i == k || j == k) continue;
                    boolean possible = true;
                    for (int l = 0; l < n; l++) {
                        if (!baseBalls[l].check(new char[]{i, j, k})) {
                            possible = false;
                            break;
                        }
                    }
                    if (possible) cnt++;
                }
            }
        }

        System.out.println(cnt);
    }
}

class BaseBall {
    char[] num;
    int strike, ball;

    public BaseBall(char[] num, int strike, int ball) {
        this.num = num;
        this.strike = strike;
        this.ball = ball;
    }

    boolean check(char[] o) {
        int s = 0;
        int b = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (num[i] == o[j]) {
                    if (i == j) s++;
                    else b++;
                }
            }
        }
        return strike == s && ball == b;
    }
}