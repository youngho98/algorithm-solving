import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int l = Integer.parseInt(st.nextToken());
			
			int[][] arr = new int[n][2];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				arr[i][0] = Integer.parseInt(st.nextToken()); // 맛
				arr[i][1] = Integer.parseInt(st.nextToken()); // 칼로리
			}
			
			// 경우의 수 비트마스킹
			int maxScore = 0;
			for (int i = 0; i < (1<<n); i++) {
				int score = 0; // 맛
				int calorie = 0; // 칼로리
				for (int j = 0; j < n; j++) {
					if ((i & (1<<j)) == 1<<j) {
						score += arr[j][0];
						calorie += arr[j][1];
					}
				}
				if (calorie <= l) {
					maxScore = Math.max(score, maxScore);
				}
			}
			
			System.out.println("#" + t + " " + maxScore);
		}
	}
}