import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static boolean[] visited;
    public static int[] arr, answer;
    public static int m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        answer = new int[m];
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st2.nextToken());
        }
        Arrays.sort(arr);
        visited = new boolean[n];

        seq(0);
    }
    public static void seq(int cnt) {
        if (cnt == m) {
            for (int i : answer) {
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }
        int before = 0;
        for (int i = 0; i < arr.length; i++) {
            if (visited[i] || before == arr[i]) {
                continue;
            }
            answer[cnt] = arr[i];
            visited[i] = true;
            before = arr[i];
            seq(cnt + 1);
            visited[i] = false;
        }
    }
}