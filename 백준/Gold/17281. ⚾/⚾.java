import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Main {
	static ArrayList<int[]> order = new ArrayList<>();
	static boolean[] visited = new boolean[9];
	static int[] tempOrd = new int[8];
	
	static int[][] batting;
	static boolean[] field;
	static int score, outCount;
	
	public static void main(String[] args) throws IOException {
		// 타순 결정 (0 ~ 8번타자 0 ~ 8번타순)
		permut(0);
		
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		batting = new int[n][9];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				batting[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 게임 시작
		int maxScore = 0;
		for (int[] ord : order) {
			int idx = 0;
			score = 0;
			for (int i = 0; i < n; i++) {
				outCount = 0;
				field = new boolean[4];
				while (outCount < 3) {
					player(i, ord[idx++]);
					if (idx == 9) {
						idx = 0;
					}
				}
			}
			maxScore = Math.max(score, maxScore);
		}
		
		System.out.println(maxScore);
	}
	
	// 순열 구현 (타순 경우의 수)
	static void permut(int idx) {
		if (idx == 8) {
			int[] ord = new int[9];
			for (int i = 0; i < 9; i++) {
				if (i < 3) {
					ord[i] = tempOrd[i];
				} else if (i == 3) {
					ord[i] = 0;
				} else {
					ord[i] = tempOrd[i - 1];
				}
			}
			order.add(ord);
			return;
		}
		for (int i = 1; i <= 8; i++) {
			if (visited[i]) {
				continue;
			}
			tempOrd[idx] = i;
			visited[i] = true;
			permut(idx+1);
			visited[i] = false;
		}
	}
	
	// player 타석별 결과
	static void player(int inning, int playerNum) {
		switch (batting[inning][playerNum]) {
			case 1:
				if (field[3]) {
					score++;
					field[3] = false;
				}
				if (field[2]) {
					field[3] = true;
					field[2] = false;
				}
				if (field[1]) {
					field[2] = true;
					field[1] = false;
				}
				field[1] = true;
				break;
			case 2:
				if (field[3]) {
					score++;
					field[3] = false;
				}
				if (field[2]) {
					score++;
					field[2] = false;
				}
				if (field[1]) {
					field[3] = true;
					field[1] = false;
				}
				field[2] = true;
				break;
			case 3:
				if (field[3]) {
					score++;
					field[3] = false;
				}
				if (field[2]) {
					score++;
					field[2] = false;
				}
				if (field[1]) {
					score++;
					field[1] = false;
				}
				field[3] = true;
				break;
			case 4:
				if (field[3]) {
					score++;
					field[3] = false;
				}
				if (field[2]) {
					score++;
					field[2] = false;
				}
				if (field[1]) {
					score++;
					field[1] = false;
				}
				score++;
				break;
			case 0:
				outCount++;
		}
	}
}