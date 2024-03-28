import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

public class Solution {
	
	static ArrayList<Integer>[] list;
	static int[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for (int t = 1; t <= 10; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());
			
			list = new ArrayList[101];
			for (int i = 1; i <= 100; i++) {
				list[i] = new ArrayList<>();
			}
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i += 2) {
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				list[a].add(b);
			}
			
			visited = new int[101];
			bfs(start);
			
			int max = 0;
			int maxIdx = 0;
			for (int i = 1; i <= 100; i++) {
				if (visited[i] >= max) {
					max = visited[i];
					maxIdx = i;
				}
			}
			
			sb.append("#").append(t).append(" ").append(maxIdx).append("\n");
		}
		
		System.out.println(sb);
	}
	
	static void bfs(int start) {
		Deque<Integer> deque = new ArrayDeque<>();
		deque.addLast(start);
		visited[start] = 1;
		
		while (!deque.isEmpty()) {
			int now = deque.pollFirst();
			for (int next : list[now]) {
				if (visited[next] == 0) {
					visited[next] = visited[now] + 1;
					deque.add(next);
				}
			}
		}
	}
}