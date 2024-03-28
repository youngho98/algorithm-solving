import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static int[] parent;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int g = Integer.parseInt(br.readLine());
		int p = Integer.parseInt(br.readLine());
		
		parent = new int[g + 1];
		for (int i = 1; i <= g; i++) {
			parent[i] = i;
		}
		
		int cnt = 0;
		for (int i = 0; i < p; i++) {
			int plane = Integer.parseInt(br.readLine());
			int x = find(plane);
			if (x == 0) {
				break;
			}
			union(x, x - 1);
			cnt++;
		}
		
		System.out.println(cnt);
	}
	
	static int find(int x) {
		if (parent[x] == x) {
			return x;
		}
		return parent[x] = find(parent[x]);
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
}