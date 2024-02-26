import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 수도꼭지 입력
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] water = new int[n + 1];
        boolean[] closed = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            water[i] = Integer.parseInt(st.nextToken());
        }
        // 현재 나오는 물의 양
        long now = 0L;
        for (int i = 1; i <= n; i++) {
            now += water[i];
        }
        System.out.println(now);
        // 명령 실행
        int q = Integer.parseInt(br.readLine());
        for (int i = 0; i < q; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st2.nextToken());
            if (cmd == 1) {
                int num = Integer.parseInt(st2.nextToken());
                int change = Integer.parseInt(st2.nextToken());
                if (closed[num]) {
                    water[num] = change;
                } else {
                    now -= water[num];
                    water[num] = change;
                    now += water[num];
                }
            } else {
                int num = Integer.parseInt(st2.nextToken());
                if (closed[num]) {
                    now += water[num];
                    closed[num] = false;
                } else {
                    now -= water[num];
                    closed[num] = true;
                }
            }
            System.out.println(now);
        }
    }
}