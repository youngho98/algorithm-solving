import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	
	static int[] parent;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			
			// 섬 배열 생성
			int n = Integer.parseInt(br.readLine());
			int[][] island = new int[n][2];
			
			// x 좌표
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				island[i][0] = Integer.parseInt(st.nextToken());
			}
			
			// y 좌표
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				island[i][1] = Integer.parseInt(st.nextToken());
			}
			
			// 환경부담 세율
			double e = Double.parseDouble(br.readLine());
			
			// 간선 입력
			Line[] lines = new Line[n * (n - 1) / 2];
			int idx = 0;
			for (int i = 0; i < n; i++) {
				for (int j = i + 1; j < n; j++) {
					lines[idx++] = new Line(i, j, e * distance(island[i], island[j]));
				}
			}
			
			// 간선 정렬
			Arrays.sort(lines, (o1, o2) -> (int) ((o1.cost - o2.cost) * 1000));
			
			// MST (Kruskal)
			parent = new int[n];
			for (int i = 0; i < n; i++) {
				parent[i] = i;
			}
			
			int cnt = 0;
			double ans = 0;
			for (int i = 0; i < idx; i++) {
				int a = lines[i].start;
				int b = lines[i].end;
				if (!unionFind(a, b)) {
					ans += lines[i].cost;
					union(a, b);
					cnt++;
				}
				if (cnt == n - 1) {
					break;
				}
			}
			
			sb.append("#").append(t).append(" ").append(Math.round(ans)).append("\n");
		}
		
		System.out.println(sb);
	}
	
	static double distance(int[] i1, int[] i2) {
		return (double) (i1[0] - i2[0]) * (double) (i1[0] - i2[0]) + (double) (i1[1] - i2[1]) * (double) (i1[1] - i2[1]);
	}
	
	static int find(int x) {
		if (parent[x] == x) {
			return x;
		}
		return find(parent[x]);
	}
	
	static void union(int x, int y) {
		x = find(x);
		y = find(y);
		if (x < y) {
			parent[y] = x;
		} else if (x > y) {
			parent[x] = y;
		}
	}
	
	static boolean unionFind(int x, int y) {
		if (find(x) == find(y)) {
			return true;
		}
		return false;
	}
}

class Line {
	int start, end;
	double cost;

	public Line(int start, int end, double cost) {
		this.start = start;
		this.end = end;
		this.cost = cost;
	}
}