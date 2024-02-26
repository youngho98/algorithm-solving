import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // 값 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int k = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[(int) Math.pow(2, k) - 1];
        for (int i = 0; i < (int) Math.pow(2, k) - 1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        // index 기준으로 출력 리스트 만들기
        ArrayList<Integer>[] answer = new ArrayList[k];
        int start = (int)Math.pow(2, k - 1) - 1;
        for (int i = 0; i < k; i++) {
            answer[i] = new ArrayList<>();
            answer[i].add(start);
            start /= 2;
        }
        int gap = 2;
        for (int i = k - 1; i >= 0; i--) {
            int num = answer[i].get(0) + gap;
            while (num < (int) Math.pow(2, k) - 1) {
                answer[i].add(num);
                num += gap;
            }
            gap *= 2;
        }
        // 출력
        for (int i = 0; i < k; i++) {
            for (int idx : answer[i]) {
                bw.write(arr[idx] + " ");
            }
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}