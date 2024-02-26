import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        int[][] score = new int[n][3];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                score[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] dpMax = new int[n + 1][3];
        for (int i = 1; i <= n; i++) {
            dpMax[i][0] = Math.max(dpMax[i-1][0], dpMax[i-1][1]) + score[i-1][0];
            dpMax[i][1] = Math.max(Math.max(dpMax[i-1][0], dpMax[i-1][1]), dpMax[i-1][2]) + score[i-1][1];
            dpMax[i][2] = Math.max(dpMax[i-1][1], dpMax[i-1][2]) + score[i-1][2];
        }

        int[][] dpMin = new int[n + 1][3];
        for (int i = 1; i <= n; i++) {
            dpMin[i][0] = Math.min(dpMin[i-1][0], dpMin[i-1][1]) + score[i-1][0];
            dpMin[i][1] = Math.min(Math.min(dpMin[i-1][0], dpMin[i-1][1]), dpMin[i-1][2]) + score[i-1][1];
            dpMin[i][2] = Math.min(dpMin[i-1][1], dpMin[i-1][2]) + score[i-1][2];
        }

        System.out.print(Math.max(Math.max(dpMax[n][0], dpMax[n][1]), dpMax[n][2]));
        System.out.print(" ");
        System.out.print(Math.min(Math.min(dpMin[n][0], dpMin[n][1]), dpMin[n][2]));
    }
}