import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int[] parent;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		// 유니온 파인드
		parent = new int[n];
		for (int i = 0; i < n; i++) {
			parent[i] = i;
		}
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				if (Integer.parseInt(st.nextToken()) == 1 && i < j) {
					union(i, j);
				}
			}
		}
		
		// 여행 계획
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] plan = new int[m];
		for (int i = 0; i < m; i++) {
			plan[i] = Integer.parseInt(st.nextToken()) - 1;
		}
		
		// 탐색
		for (int i = 0; i < m - 1; i++) {
			if (!unionFind(plan[i], plan[i + 1])) {
				System.out.println("NO");
				return;
			}
		}
		System.out.println("YES");
	}
	
	static int find(int x) {
		if (parent[x] == x) {
			return x;
		}
		return parent[x] = find(parent[x]);
	}
	
	static void union(int x, int y) {
		parent[find(y)] = find(x);
	}
	
	static boolean unionFind(int x, int y) {
		if (find(x) == find(y)) {
			return true;
		}
		return false;
	}
}