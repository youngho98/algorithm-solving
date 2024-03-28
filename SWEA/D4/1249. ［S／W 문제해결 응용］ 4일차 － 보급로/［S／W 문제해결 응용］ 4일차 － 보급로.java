import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {
	
	static char[][] map;
	static int[][] dp;
	static int n;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			
			// 입력
			n = Integer.parseInt(br.readLine());
			map = new char[n][n];
			for (int i = 0; i < n; i++) {
				map[i] = br.readLine().toCharArray();
			}
			
			// 다익스트라
			dp = new int[n][n];
			for (int i = 0; i < n; i++) {
				Arrays.fill(dp[i], 1_000_000);
			}
			dijkstra(0, 0);
			
			sb.append("#").append(t).append(" ").append(dp[n - 1][n - 1]).append("\n");
		}
		
		System.out.println(sb);
	}
	
	static void dijkstra(int x, int y) {
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		
		PriorityQueue<Point> pq = new PriorityQueue<>((o1, o2) -> o1.time - o2.time);
		pq.offer(new Point(x, y, 0));
		dp[x][y] = 0;
		
		while (!pq.isEmpty()) {
			Point now = pq.poll();
			for (int i = 0; i < 4; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];
				if (inMap(nx, ny) && now.time + map[nx][ny] - '0' < dp[nx][ny]) {
					dp[nx][ny] = now.time + map[nx][ny] - '0';
					pq.offer(new Point(nx, ny, dp[nx][ny]));
				}
			}
		}
	}
	
	static boolean inMap(int x, int y) {
		return 0 <= x && x < n && 0 <= y && y < n;
	}
}

class Point {
	int x, y, time;

	public Point(int x, int y, int time) {
		this.x = x;
		this.y = y;
		this.time = time;
	}
}