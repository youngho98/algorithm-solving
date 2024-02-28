import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer> temp = new ArrayList<>();
    static ArrayList<int[]> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] e = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                e[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 순열 구하기
        permut(n, n - 1);

        // 차례 경우의 수
        int min = Integer.MAX_VALUE;
        out: for (int[] arr : list) {
            int[] order = new int[n + 1];
            order[0] = 1;
            order[n] = 1;
            for (int i = 1; i < n; i++) {
                order[i] = arr[i - 1];
            }

            int sum = 0;
            for (int i = 0; i < n; i++) {
            	if (e[order[i]][order[i + 1]] == 0) {
            		continue out;
            	}
                sum += e[order[i]][order[i + 1]];
                if (sum > min) {
                	continue out;
                }
            }

            min = Math.min(sum, min);
        }

        System.out.println(min);
    }

    static void permut(int n, int r) {
        if (r == 0) {
            int[] arr = new int[n - 1];
            for (int i = 0; i < n - 1; i++) {
                arr[i] = temp.get(i);
            }
            list.add(arr);
            return;
        }

        for (int i = 2; i <= n; i++) {
            if (temp.contains(i)) {
                continue;
            }
            temp.add(i);
            permut(n, r - 1);
            temp.remove(temp.size() - 1);
        }
    }
}