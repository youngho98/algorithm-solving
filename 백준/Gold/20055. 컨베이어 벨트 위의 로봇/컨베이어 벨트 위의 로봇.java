import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] hp;
    static boolean[] robot;
    static int n, cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        // 컨베이어 입력
        st = new StringTokenizer(br.readLine());
        hp = new int[n * 2];
        robot = new boolean[n * 2];
        for (int i = 0; i < n * 2; i++) {
            hp[i] = Integer.parseInt(st.nextToken());
        }

        int step = 1;
        while (true) {
            // 1. 회전
            rotate();
            // 2. 로봇 이동 & 올리기
            move();
            // 3. 종료 확인
            if (cnt >= k) {
                System.out.println(step);
                return;
            }
            step++;
        }
    }

    static void rotate() {
        int temp = hp[n * 2 - 1];
        for (int i = n * 2 - 1; i > 0; i--) {
            hp[i] = hp[i - 1];
        }
        hp[0] = temp;

        boolean tmp = robot[n * 2 - 1];
        for (int i = n * 2 - 1; i > 0; i--) {
            robot[i] = robot[i - 1];
        }
        robot[0] = tmp;
        robot[n - 1] = false;
    }

    static void move() {
        boolean temp = robot[n * 2 - 1];
        for (int i = n * 2 - 1; i > 0; i--) {
            if (robot[i - 1] && !robot[i] && hp[i] > 0) {
                robot[i] = true;
                robot[i - 1] = false;
                hp[i]--;
                if (hp[i] == 0) {
                    cnt++;
                }
            }
        }
        robot[0] = temp;
        robot[n - 1] = false;

        if (!robot[0] && hp[0] > 0) {
            robot[0] = true;
            hp[0]--;
            if (hp[0] == 0) {
                cnt++;
            }
        }
    }
}