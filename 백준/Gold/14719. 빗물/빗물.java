import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        // 배열 생성
        int[] map = new int[w];
        int block = 0;
        for (int i = 0; i < w; i++) {
            map[i] = Integer.parseInt(st.nextToken());
            block += map[i];
        }

        // 물의 양 계산하기
        int water = h * w - block;

        // 왼쪽부터 흘러내린 물의 양
        int maxL = 0;
        for (int i = 0; i < w; i++) {
            maxL = Math.max(maxL, map[i]);
            water -= h - maxL;
        }

        // 오른쪽부터 흘러내린 물의 양
        int maxR = 0;
        for (int i = w - 1; i >= 0; i--) {
            maxR = Math.max(maxR, map[i]);
            water -= maxL - maxR;
        }

        System.out.println(water);
    }
}