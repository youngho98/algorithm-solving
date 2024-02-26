import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		int max = 1;
		int[] dp = new int[n];
		dp[0] = 1;
		for (int i = 1; i < n; i++) {
			int dpMax = 0;
			for (int j = 0; j < i; j++) {
				if (arr[j] < arr[i]) {
					dpMax = Math.max(dpMax, dp[j]);
				}
			}
			dp[i] = dpMax + 1;
			max = Math.max(max, dp[i]);
		}
		
		System.out.println(n - max);
	}
}