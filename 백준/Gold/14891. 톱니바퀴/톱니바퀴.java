import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static char[][] wheel = new char[4][];
    static int[] up = new int[4];
    static int[] rotate;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 톱니바퀴 입력
        for (int i = 0; i < 4; i++) {
            wheel[i] = br.readLine().toCharArray();
        }

        // 회전
        int k = Integer.parseInt(br.readLine());
        for (int i = 0; i < k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken()) - 1;
            int dir = Integer.parseInt(st.nextToken());
            // 연결 확인
            boolean[] connect = new boolean[3];
            for (int j = 0; j < 3; j++) {
                if (wheel[j][(up[j] + 2) % 8] != wheel[j + 1][(up[j + 1] + 6) % 8]) {
                    connect[j] = true;
                }
            }
            // 연쇄 회전
            rotate = new int[4];
            wheelRotate(num, dir);
            int n = num;
            while (n > 0 && connect[n - 1]) {
                wheelRotate(n - 1, -rotate[n]);
                n--;
            }
            n = num;
            while (n < 3 && connect[n]) {
                wheelRotate(n + 1, -rotate[n]);
                n++;
            }
        }

        // 점수 계산
        int score = 0;
        for (int i = 0; i < 4; i++) {
            if (wheel[i][up[i]] == '1') {
                score += (int) Math.pow(2, i);
            }
        }

        System.out.println(score);
    }

    static void wheelRotate(int num, int dir) {
        if (dir == 1) {
            up[num] = (up[num] + 7) % 8;

        } else if (dir == -1) {
            up[num] = (up[num] + 1) % 8;
        }
        rotate[num] = dir;
    }
}