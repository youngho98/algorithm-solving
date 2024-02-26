import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	
	static boolean[][] map = new boolean[101][101];
	static int n;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			dragonCurve(x, y, d, g);
		}
		
		int cnt = 0;
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if (check(i, j)) {
					cnt++;
				}
			}
		}
		
		System.out.println(cnt);
	}
	
	static void dragonCurve(int x, int y, int d, int g) {
		int[] xd = {1, 0, -1, 0};
		int[] yd = {0, -1, 0, 1};
		
		ArrayList<Point> list = new ArrayList<>();
		list.add(new Point(x, y));
		list.add(new Point(x + xd[d], y + yd[d]));
		
		for (int i = 0; i < g; i++) {
			Point center = list.get(list.size() - 1);
			for (int j = list.size() - 2; j >= 0; j--) {
				Point p = list.get(j);
				int dx = center.x - p.x;
				int dy = center.y - p.y;
				list.add(new Point(center.x + dy, center.y - dx));
			}
		}
		
		for (Point p : list) {
			map[p.x][p.y] = true; 
		}
	}
	
	static boolean inMap(int x, int y) {
		return 0 <= x && x <= n && 0 <= y && y <= n;
	}
	
	static boolean check(int x, int y) {
		return map[x][y] && map[x + 1][y] && map[x][y + 1] && map[x + 1][y + 1];
	}
}

class Point {
	int x, y;

	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
}