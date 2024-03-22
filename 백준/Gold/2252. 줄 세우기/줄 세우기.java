import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		ArrayList<Integer>[] list = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++) {
			list[i] = new ArrayList<>();
		}
		
		// 인접리스트 & 차수 입력
		int[] degree = new int[n + 1];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			degree[b]++;
		}
		
		// 위상 정렬
		boolean[] visited = new boolean[n + 1];
		Deque<Integer> deque = new ArrayDeque<>();
		for (int i = 1; i <= n; i++) {
			if (degree[i] == 0) {
				deque.addLast(i);
				visited[i] = true;
			}
		}
		
		while (!deque.isEmpty()) {
			int now = deque.pollFirst();
			sb.append(now).append(" ");
			
			for (int next : list[now]) {
				if (!visited[next] && --degree[next] == 0) {
					deque.addLast(next);
					visited[next] = true;
				}
			}
		}
		
		// 출력
		System.out.println(sb);
	}
}