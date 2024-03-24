import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        // 보석 입력 (무게, 가치)
        int[][] jewel = new int[n][];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            jewel[i] = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
        }

        // 가방 입력
        int[] bag = new int[k];
        for (int i = 0; i < k; i++) {
            bag[i] = Integer.parseInt(br.readLine());
        }

        // 보석 무게별 오름차순 정렬
        Arrays.sort(jewel, (o1, o2) -> o1[0] - o2[0]);

        // 가방 무게별 오름차순 정렬
        Arrays.sort(bag);

        // 보석가격의 합 구하기
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
        int i = 0;
        int j = 0;
        long price = 0;
        while (j < k) {
            if (i < n) {
                if (jewel[i][0] <= bag[j]) {
                    pq.offer(jewel[i++][1]);
                } else {
                    j++;
                    if (pq.isEmpty()) {
                        continue;
                    }
                    price += pq.poll();
                }
            } else {
                j++;
                if (pq.isEmpty()) {
                    continue;
                }
                price += pq.poll();
            }
        }

        // 정답 출력
        System.out.println(price);
    }
}