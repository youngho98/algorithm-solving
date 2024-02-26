import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	
	static boolean[][] pixel;
	static int n, m;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		// display 생성
		double[][] display = new double[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				display[i][j] = (Double.parseDouble(st.nextToken()) 
						+ Double.parseDouble(st.nextToken()) + Double.parseDouble(st.nextToken())) / 3;
			}
		}
		// 픽셀값 255를 true로 배열 생성
		int t = Integer.parseInt(br.readLine());
		
		pixel = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (display[i][j] >= t) {
					pixel[i][j] = true;
				}
			}
		}
		// bfs 탐색
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (pixel[i][j]) {
					bfs(i, j);
					cnt++;
				}
			}
		}
		
		System.out.println(cnt);
	}
	
	static void bfs(int a, int b) {
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		Deque<Point> deque = new ArrayDeque<>();
		deque.addLast(new Point(a, b));
		pixel[a][b] = false;
		while (!deque.isEmpty()) {
			Point node = deque.pollFirst();
			int x = node.x;
			int y = node.y;
			for (int i = 0; i < 4; i++) {
				if (x + dx[i] < 0 || x + dx[i] >= n || y + dy[i] < 0 || y + dy[i] >= m) {
					continue;
				}
				if (pixel[x + dx[i]][y + dy[i]]) {
					deque.addLast(new Point(x + dx[i], y + dy[i]));
					pixel[x + dx[i]][y + dy[i]] = false;
				}
			}
		}
	}
}

class Point {
	int x, y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
}