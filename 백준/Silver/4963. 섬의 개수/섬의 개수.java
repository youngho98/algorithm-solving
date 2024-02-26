import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	
	static int[][] map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		while (true) {
			// 맵 생성
			StringTokenizer st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			if (w == 0 && h == 0) {
				break;
			}
			
			map = new int[h][w];
			for (int i = 0; i < h; i++) {
				StringTokenizer st2 = new StringTokenizer(br.readLine());
				for (int j = 0; j < w; j++) {
					map[i][j] = Integer.parseInt(st2.nextToken());
				}
			}
			
			// bfs로 섬 개수 탐색
			int cnt = 0;
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (map[i][j] == 1) {
						cnt++;
						bfs(i, j);
					}
				}
			}
			bw.write(cnt + "\n");
		}
		bw.flush();
		bw.close();
	}
	
	static void bfs(int a, int b) {
		int[] dx = new int[]{-1, -1, 0, 1, 1, 1, 0, -1};
		int[] dy = new int[]{0, 1, 1, 1, 0, -1, -1, -1};
		
		Deque<Integer> dqX = new ArrayDeque<>();
		Deque<Integer> dqY = new ArrayDeque<>();
		dqX.addLast(a);
		dqY.addLast(b);
		
		while (!dqX.isEmpty()) {
			int x = dqX.pollFirst();
			int y = dqY.pollFirst();
			
			for (int nx : dx) {
				for (int ny : dy) {
					if (x + nx < 0 || x + nx >= map.length || y + ny < 0 || y + ny >= map[0].length) {
						continue;
					}
					if (map[x + nx][y + ny] == 1) {
						dqX.addLast(x + nx);
						dqY.addLast(y + ny);
						map[x + nx][y + ny] = 0;
					}
				}
			}
		}	
	}
}