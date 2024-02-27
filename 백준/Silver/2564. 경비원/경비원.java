import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(br.readLine());

        int[] store = new int[(w + h) * 2];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int dir = Integer.parseInt(st.nextToken()); // 방향 - 북1, 남2, 서3, 동4
            int dist = Integer.parseInt(st.nextToken()); // 거리 - 왼쪽, 위로부터
            if (dir == 1) {
                store[i] = dist;
            } else if (dir == 4) {
                store[i] = w + dist;
            } else if (dir == 2) {
                store[i] = w * 2 + h - dist;
            } else if (dir == 3) {
                store[i] = w * 2 + h * 2 - dist;
            }
        }
        st = new StringTokenizer(br.readLine());
        int dir = Integer.parseInt(st.nextToken());
        int dist = Integer.parseInt(st.nextToken());
        int now = 0;
        if (dir == 1) {
            now = dist;
        } else if (dir == 4) {
            now = w + dist;
        } else if (dir == 2) {
            now = w * 2 + h - dist;
        } else if (dir == 3) {
            now = w * 2 + h * 2 - dist;
        }

        int sum = 0;
        for (int i = 0; i < n; i++) {
            int d = Math.abs(now - store[i]);
            if (d > w + h) {
                d = (w + h) * 2 - d;
            }
            sum += d;
        }

        System.out.println(sum);
    }
}