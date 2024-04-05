import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

public class Solution {
	
	static int n;
	static int maxLen;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			
			int[][] map = new int[n][n];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			// 가장 높은 봉우리 찾기
			int maxHeight = 0;
			ArrayList<Point> start = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (map[i][j] > maxHeight) {
						maxHeight = map[i][j];
						start.clear();
						start.add(new Point(i, j, 1));
					} else if (map[i][j] == maxHeight) {
						start.add(new Point(i, j, 1));
					}
				}
			}
			
			// 공사 전 탐색
			maxLen = 0;
			for (Point p : start) {
				bfs(p, map);
			}
		
			// 공사 후 탐색
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					for (int d = 1; d <= k; d++) {
						if (map[i][j] >= d) {
							map[i][j] -= d;
							for (Point p : start) {
								bfs(p, map);
							}
							map[i][j] += d;
						}
					}
				}
			}
			sb.append("#").append(t).append(" ").append(maxLen).append("\n");
		}
		System.out.println(sb);
	}

	static void bfs(Point p, int[][] map) {
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		Deque<Point> deque = new ArrayDeque<>();
		deque.addLast(p);
		
		while (!deque.isEmpty()) {
			Point now = deque.pollFirst();
			maxLen = Math.max(maxLen, now.dist);
			for (int i = 0; i < 4; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];
				if (inMap(nx, ny) && map[now.x][now.y] > map[nx][ny]) {
					deque.addLast(new Point(nx, ny, now.dist + 1));
				}
			}
		}
	}
	
	static boolean inMap(int x, int y) {
		return 0 <= x && x < n && 0 <= y && y < n;
	}
}

class Point {
	int x, y, dist;

	public Point(int x, int y, int dist) {
		this.x = x;
		this.y = y;
		this.dist = dist;
	}
}