import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[][] matrix;
    static boolean[][] answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());

        // 인접 행렬
        matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 정답 행렬
        answer = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            start(i);
        }

        // 정답 출력
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (answer[i][j]) {
                    sb.append(1);
                } else {
                    sb.append(0);
                }
                sb.append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    static void start(int s) {
        boolean[] visited = new boolean[n];

        Deque<Integer> deque = new ArrayDeque<>();
        deque.addLast(s);

        while (!deque.isEmpty()) {
            int now = deque.pollFirst();
            for (int i = 0; i < n; i++) {
                if (matrix[now][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    deque.addLast(i);
                }
            }
        }

        answer[s] = visited;
    }
}