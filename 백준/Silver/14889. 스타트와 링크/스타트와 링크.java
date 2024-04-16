import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int n;
	static int member;
	static int min;
	static int[][] status;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 입력
		n = Integer.parseInt(br.readLine());
		status = new int[n][n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				status[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		min = Integer.MAX_VALUE;
		team(0, 0);
		
		System.out.println(min);
	}
	
	static void team(int idx, int cnt) {
		if (cnt == n / 2) {
			min = Math.min(min, diff(member));
			return;
		}
		if (idx == n) {
			return;
		}
		
		member += 1 << idx;
		team(idx + 1, cnt + 1);
		member -= 1 << idx;
		team(idx + 1, cnt);
	}
	
	static int diff(int member) {
		int sumA = 0;
		for (int i = 0; i < n; i++) {
			if ((member & (1 << i)) > 0) {
				for (int j = i + 1; j < n; j++) {
					if ((member & (1 << j)) > 0) {
						sumA += status[i][j];
						sumA += status[j][i];
					}
				}
			}
		}
		
		int sumB = 0;
		for (int i = 0; i < n; i++) {
			if ((member & (1 << i)) == 0) {
				for (int j = i + 1; j < n; j++) {
					if ((member & (1 << j)) == 0) {
						sumB += status[i][j];
						sumB += status[j][i];
					}
				}
			}
		}
		
		return Math.abs(sumA - sumB);
	}
}