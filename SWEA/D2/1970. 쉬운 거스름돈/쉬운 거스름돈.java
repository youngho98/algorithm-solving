import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int[] arr = {50000, 10000, 5000, 1000, 500, 100, 50, 10};
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			sb.append("#").append(t).append("\n");
			int n = Integer.parseInt(br.readLine());
			int idx = 0;
			int cnt = 0;
			while (idx < 8) {
				if (n >= arr[idx]) {
					cnt++;
					n -= arr[idx];
				} else {
					sb.append(cnt).append(" ");
					cnt = 0;
					idx++;
				}
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
}