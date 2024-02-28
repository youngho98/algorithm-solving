import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int[][] arr;
	static int n;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		int[][] start = new int[n][n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				start[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int max = 0;
		for (int a = 0; a < 4; a++) {
			for (int b = 0; b < 4; b++) {
				for (int c = 0; c < 4; c++) {
					for (int d = 0; d < 4; d++) {
						for (int e = 0; e < 4; e++) {
							for (int i = 0; i < n; i++) {
								for (int j = 0; j < n; j++) {
									arr[i][j] = start[i][j];
								}
							}
							move(a);
							move(b);
							move(c);
							move(d);
							move(e);
							
							for (int i = 0; i < n; i++) {
								for (int j = 0; j < n; j++) {
									max = Math.max(max, arr[i][j]);
								}
							}
						}
					}
				}
			}		
		}
		
		System.out.println(max);
	}
	
	static void move(int dir) {
		if (dir == 0) { // 왼쪽
			for (int i = 0; i < n; i++) {
				int[] temp = new int[n];
				int idx = 0;
				
				// 한 쪽으로 몰기
				for (int j = 0; j < n; j++) {
					if (arr[i][j] != 0) {
						temp[idx++] = arr[i][j];
					}
				}
				for (int j = 0; j < n; j++) {
					arr[i][j] = temp[j];
				}
				
				// 합치기
				temp = new int[n];
				idx = 0;
				for (int j = 0; j < n; j++) {
					if (arr[i][j] == 0) {
						continue;
					}
					if (j + 1 < n && arr[i][j] == arr[i][j + 1]) {
						temp[idx++] = arr[i][j] * 2;
						j++;
					} else {
						temp[idx++] = arr[i][j];
					}
				}
				for (int j = 0; j < n; j++) {
					arr[i][j] = temp[j];
				}
			}
		}
		
		if (dir == 1) { // 위쪽
			for (int i = 0; i < n; i++) {
				int[] temp = new int[n];
				int idx = 0;
				
				// 한 쪽으로 몰기
				for (int j = 0; j < n; j++) {
					if (arr[j][i] != 0) {
						temp[idx++] = arr[j][i];
					}
				}
				for (int j = 0; j < n; j++) {
					arr[j][i] = temp[j];
				}
				
				// 합치기
				temp = new int[n];
				idx = 0;
				for (int j = 0; j < n; j++) {
					if (arr[j][i] == 0) {
						continue;
					}
					if (j + 1 < n && arr[j][i] == arr[j + 1][i]) {
						temp[idx++] = arr[j][i] * 2;
						j++;
					} else {
						temp[idx++] = arr[j][i];
					}
				}
				for (int j = 0; j < n; j++) {
					arr[j][i] = temp[j];
				}
			}
		}
		
		if (dir == 2) { // 오른쪽
			for (int i = 0; i < n; i++) {
				int[] temp = new int[n];
				int idx = n - 1;
				
				// 한 쪽으로 몰기
				for (int j = n - 1; j >= 0; j--) {
					if (arr[i][j] != 0) {
						temp[idx--] = arr[i][j];
					}
				}
				for (int j = 0; j < n; j++) {
					arr[i][j] = temp[j];
				}
				
				// 합치기
				temp = new int[n];
				idx = n - 1;
				for (int j = n - 1; j >= 0; j--) {
					if (arr[i][j] == 0) {
						continue;
					}
					if (j - 1 >= 0 && arr[i][j] == arr[i][j - 1]) {
						temp[idx--] = arr[i][j] * 2;
						j--;
					} else {
						temp[idx--] = arr[i][j];
					}
				}
				for (int j = 0; j < n; j++) {
					arr[i][j] = temp[j];
				}
			}
		}
		
		if (dir == 3) { // 아래쪽
			for (int i = 0; i < n; i++) {
				int[] temp = new int[n];
				int idx = n - 1;
				
				// 한 쪽으로 몰기
				for (int j = n - 1; j >= 0; j--) {
					if (arr[j][i] != 0) {
						temp[idx--] = arr[j][i];
					}
				}
				for (int j = 0; j < n; j++) {
					arr[j][i] = temp[j];
				}
				
				// 합치기
				temp = new int[n];
				idx = n - 1;
				for (int j = n - 1; j >= 0; j--) {
					if (arr[j][i] == 0) {
						continue;
					}
					if (j - 1 >= 0 && arr[j][i] == arr[j - 1][i]) {
						temp[idx--] = arr[j][i] * 2;
						j--;
					} else {
						temp[idx--] = arr[j][i];
					}
				}
				for (int j = 0; j < n; j++) {
					arr[j][i] = temp[j];
				}
			}
		}
	}
}