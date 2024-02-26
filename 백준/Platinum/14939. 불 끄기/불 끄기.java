import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static char[][] map;
    static boolean[][] light;
    static int minVal = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 전구 on/off 입력 받기
        map = new char[10][10];
        for (int i = 0; i < 10; i++) {
            map[i] = br.readLine().toCharArray();
        }

        // 첫 줄의 스위치를 켜고 끄는 조합
        int minVal = Integer.MAX_VALUE;
        for (int bit = 0; bit < 1024; bit++) {

            // 경우의 수마다 전구 배열 생성
            light = new boolean[10][10];
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    if (map[i][j] == 'O') {
                        light[i][j] = true;
                    }
                }
            }

            // 첫 줄 스위치 누르기
            int cnt = 0;
            for (int i = 0; i < 10; i++) {
                if ((bit & (int) Math.pow(2, i)) == (int) Math.pow(2, i)) {
                    change(0, i);
                    cnt++;
                }
            }

            // 그 다음 줄부터 누르기
            for (int i = 1; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    if (light[i - 1][j]) {
                        change(i, j);
                        cnt++;
                    }
                }
            }

            // 다 꺼졌는지 체크
            if (check()) {
                minVal = Math.min(cnt, minVal);
            }
        }

        // 정답 출력
        if (minVal == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(minVal);
        }
    }

    static void change(int x, int y) {
        int[] dx = {0, -1, 1, 0, 0};
        int[] dy = {0, 0, 0, -1, 1};

        for (int i = 0; i < 5; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (inMap(nx, ny)) {
                if (light[nx][ny]) {
                    light[nx][ny] = false;
                } else {
                    light[nx][ny] = true;
                }
            }
        }
    }

    static boolean inMap(int x, int y) {
        return 0 <= x && x < 10 && 0 <= y && y < 10;
    }

    static boolean check() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (light[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}