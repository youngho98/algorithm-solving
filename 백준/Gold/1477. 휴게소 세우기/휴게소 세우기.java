import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static List<Integer> dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        // 거리 리스트 만들기
        dist = new ArrayList<>();
        if (n != 0) {
            st = new StringTokenizer(br.readLine());
            int[] rest = new int[n];
            for (int i = 0; i < n; i++) {
                rest[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(rest);

            dist.add(rest[0]);
            for (int i = 1; i < n; i++) {
                dist.add(rest[i] - rest[i - 1]);
            }
            dist.add(l - rest[n - 1]);
        } else {
            dist.add(l);
        }

        // 이분탐색
        int start = 1;
        int end = l;
        while (start <= end) {
            int mid = (start + end) >> 1;
            if (check(mid) > m) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        System.out.println(start);
    }

    static int check(int mid) {
        int sum = 0;
        for (int d : dist) {
            sum += d % mid == 0 ? d / mid - 1 : d / mid;
        }
        return sum;
    }
}