import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[][] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		// 비용 배열
		arr = new int[n][3];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 정답 출력
		System.out.println(Math.min(Math.min(rgb(0), rgb(1)), rgb(2)));
	}
	
	// 첫 집이 빨강, 초록, 파랑으로 시작하는 비용의 최소값
	static int rgb(int idx) {
		int[][] dp = new int[n][3];
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < 3; j++) {
				dp[i][j] = 1_000_001;
			}
		}
		
		dp[0][idx] = arr[0][idx];
		for (int i = 1; i < n; i++) {
			dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + arr[i][0];
			dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + arr[i][1];
			dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + arr[i][2];
		}
		
		dp[n-1][idx] = Integer.MAX_VALUE;
		
		return Math.min(Math.min(dp[n-1][0], dp[n-1][1]), dp[n-1][2]);
	}
}