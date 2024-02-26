import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	
	static int[][] map;
	static int n, m, d;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		// 맵 생성
		map = new int[n][m];
		for (int i = 0; i < n; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st2.nextToken());
			}
		}
		// 궁수를 배치할 좌표 배열 (조합 mC3)
		ArrayList<int[]> list = new ArrayList<>();
		for (int i = 0; i < m; i++) {
			for (int j = i + 1; j < m; j++) {
				for (int k = j + 1; k < m; k++) {
					list.add(new int[]{i, j, k});
				}
			}
		}
		// 궁수 배치하는 각각의 경우의 수에서 공격
		int max = 0;
		for (int[] arr : list) {
			max = Math.max(max, attack(arr));
		}
		
		System.out.println(max);
	}
	
	static int attack(int[] arr) {
		int cnt = 0;
		int archerX = n;
		// newMap 생성
		int[][] newMap = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				newMap[i][j] = map[i][j];
			}
		}
		
		while (archerX > 0) {
			// 매 턴 공격
			int[][] points = new int[3][2];
			points[0] = shoot(archerX, arr[0], newMap);
			points[1] = shoot(archerX, arr[1], newMap);
			points[2] = shoot(archerX, arr[2], newMap);
			
			for (int[] point : points) {
				if (point[0] >= 0 && newMap[point[0]][point[1]] == 1) {
					newMap[point[0]][point[1]] = 0;
					cnt++;
				}
			}
			
			archerX--;
		}
		return cnt;
	}
	
	static int[] shoot(int a, int b, int[][] map) {
		for (int dist = 1; dist <= d; dist++) {
			int x = a;
			int y = b - dist;
			boolean xMinus = true;
			while (true) {
				// 적이 있으면 좌표 리턴
				if (0 <= x && x < a && 0 <= y && y < m) {
					if (map[x][y] == 1) {
						return new int[]{x, y};
					}
				}
				// x값 증감변화, y값 증가
				if (x == a - dist) {
					xMinus = false;
				}
				
				if (xMinus) {
					x--;
				} else {
					x++;
				}
				y++;
				
				if (x == a) {
					break;
				}
			}
		}
		return new int[]{-1, -1};
	}
}