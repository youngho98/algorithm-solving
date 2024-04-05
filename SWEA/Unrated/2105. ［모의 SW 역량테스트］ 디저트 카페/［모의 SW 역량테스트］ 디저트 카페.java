import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static int[] dx = {1, 1, -1, -1};
	static int[] dy = {1, -1, -1, 1};
	static boolean[] dessert;
	static int[][] map;
	static int max;
	static int startX, startY;
	static int n;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			n = Integer.parseInt(br.readLine());
			map = new int[n][n];
			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken()) - 1;
				}
			}
			
			max = -1;
			for (int i = 0; i < n - 2; i++) {
				for (int j = 1; j < n - 1; j++) {
					dessert = new boolean[100];
					startX = i;
					startY = j;
					eat(i, j, 0);
				}
			}
			sb.append("#").append(t).append(" ").append(max).append("\n");
		}
		System.out.println(sb);
	}

	static void eat(int x, int y, int d) {
		if (dessert[map[x][y]] && x == startX && y == startY) {
			int cnt = 0;
			for (int i = 0; i < 100; i++) {
				if (dessert[i]) {
					cnt++;
				}
			}
			max = Math.max(max, cnt);
			return;
		}
		
		int nx = x + dx[d];
		int ny = y + dy[d];
		if (inMap(nx, ny) && !dessert[map[nx][ny]]) {
			dessert[map[nx][ny]] = true;
			eat(nx, ny, d);
			dessert[map[nx][ny]] = false;
		}
		if (d < 3) {
			d++;
			nx = x + dx[d];
			ny = y + dy[d];
			if (inMap(nx, ny) && !dessert[map[nx][ny]]) {
				dessert[map[nx][ny]] = true;
				eat(nx, ny, d);
				dessert[map[nx][ny]] = false;
			}
		}
	}
	
	static boolean inMap(int x, int y) {
		return 0 <= x && x < n && 0 <= y && y < n;
	}
}