import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		
		int[] dp = new int[n + 1];
		Deque<Integer>[] deque = new ArrayDeque[n + 1];
		for (int i = 1; i <= n; i++) {
			deque[i] = new ArrayDeque<>();
		}
		
		deque[1].add(1);
		
		for (int i = 2; i <= n; i++) {
			int min = dp[i - 1];
			int cmd = 1;
			if (i % 2 == 0 && min > dp[i / 2]) {
				min = dp[i / 2];
				cmd = 2;
			}
			if (i % 3 == 0 && min > dp[i / 3]) {
				min = dp[i / 3];
				cmd = 3;
			}
			
			switch (cmd) {
			case 1:
				dp[i] = dp[i - 1] + 1;
				deque[i] = new ArrayDeque<>(deque[i - 1]);
				deque[i].addFirst(i);
				break;
			case 2:
				dp[i] = dp[i / 2] + 1;
				deque[i] = new ArrayDeque<>(deque[i / 2]);
				deque[i].addFirst(i);
				break;
			case 3:
				dp[i] = dp[i / 3] + 1;
				deque[i] = new ArrayDeque<>(deque[i / 3]);
				deque[i].addFirst(i);
			}
		}
		
		sb.append(dp[n]).append("\n");
		for (int k : deque[n]) {
			sb.append(k).append(" ");
		}
		
		System.out.println(sb);
	}
}