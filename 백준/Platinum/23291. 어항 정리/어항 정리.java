import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int[][] map;
	static int[] arr;
	static int n;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		// 1차원 어항 생성
		st = new StringTokenizer(br.readLine());
		arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		// 어항 정리 횟수
		int count = 0;
		
		while (true) {
			// 2차원 맵으로 변경
			map = new int[n][n];
			for (int i = 0; i < n; i++) {
				map[i][0] = arr[i];
			}
			
			// 물고기 수가 최소인 어항에 물고기를 넣는다.
			int min = Integer.MAX_VALUE;
			for (int i = 0; i < n; i++) {
				min = Math.min(map[i][0], min);
			}
			for (int i = 0; i < n; i++) {
				if (map[i][0] == min) {
					map[i][0]++;
				}
			}
			
			// 가장 왼쪽을 어항을 위로 쌓는다.
			map[1][1] = map[0][0];
			map[0][0] = 0;
			
			// 2개 이상 쌓인 어항 찾아서 90도 회전 반복
			rotate90();
			
			// 물고기의 수를 조절
			fishmove();
			
			// 다시 1차원으로 변환
			arr = new int[n];
			int idx = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (map[i][j] != 0) {
						arr[idx++] = map[i][j];
					}
				}
			}
			
			// 왼쪽에 있는 절반을 오른쪽 절반 위로 180도 회전시켜 쌓기 2회 반복
			map = new int[n][n];
			rotate180();
			
			// 물고기의 수를 조절
			fishmove();
			
			// 다시 1차원으로 변환
			arr = new int[n];
			idx = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (map[i][j] != 0) {
						arr[idx++] = map[i][j];
					}
				}
			}
			
			count++;
			
			// 물고기가 가장 많은 어항, 가장 적은 어항 차이 계산
			int minFish = Integer.MAX_VALUE;
			int maxFish = Integer.MIN_VALUE;
			for (int i = 0; i < n; i++) {
				minFish = Math.min(minFish, arr[i]);
				maxFish = Math.max(maxFish, arr[i]);
			}
			
			if (maxFish - minFish <= k) {
				break;
			}
		}
		
		System.out.println(count);
	}
	
	static void rotate90() {
		while (true) {
			int start = 0;
			int end = 0;
			for (int i = 0; i < n; i++) {
				if (map[i][1] != 0) {
					start = i;
					break;
				}
			}
			for (int i = n - 1; i >= 0; i--) {
				if (map[i][1] != 0) {
					end = i;
					break;
				}
			}
			
			int height = 0;
			for (int i = 0; i < n; i++) {
				if (map[start][i] == 0) {
					height = i;
					break;
				}
			}
			
			if (end + height > n - 1) {
				break;
			}
			
			for (int i = start; i <= end; i++) { // 2, 3
				for (int j = 0; j < height; j++) { // 0, 1
					map[end + j + 1][end - i + 1] = map[i][j];
					map[i][j] = 0;
				}
			}
		}
	}
	
	static void fishmove() {
		int[][] nMap = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				nMap[i][j] = map[i][j];
			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (nMap[i][j] != 0) {
					if (j + 1 < n && nMap[i][j + 1] != 0) {
						int d = nMap[i][j] - nMap[i][j + 1];
						if (d > 0) {
							map[i][j] -= d / 5;
							map[i][j + 1] += d / 5;
						} else if (d < 0) {
							map[i][j + 1] -= (-d) / 5;
							map[i][j] += (-d) / 5;
						}
					}
					if (i + 1 < n && nMap[i + 1][j] != 0) {
						int d = nMap[i][j] - nMap[i + 1][j];
						if (d > 0) {
							map[i][j] -= d / 5;
							map[i + 1][j] += d / 5;
						} else if (d < 0) {
							map[i + 1][j] -= (-d) / 5;
							map[i][j] += (-d) / 5;
						}
					}
				}
			}
		}
	}
	
	static void rotate180() {
		int x = (n / 4) - 1;
		int y = 1;
		for (int i = 0; i < n; i++) {
			map[x][y] = arr[i];
			if (y % 2 == 1) {
				x--;
			} else {
				x++;
			}
			if (x < 0) {
				x = 0;
				y++;
			}
			if (x > (n / 4) - 1) {
				x = (n / 4) - 1;
				y++;
			}
			if (y > 3) {
				y = 0;
			}
		}
	}
}