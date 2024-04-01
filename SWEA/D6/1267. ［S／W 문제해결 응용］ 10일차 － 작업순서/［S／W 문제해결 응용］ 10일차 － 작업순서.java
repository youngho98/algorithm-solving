import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for (int t = 1; t <= 10; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			ArrayList<Integer>[] list = new ArrayList[v + 1];
			for (int i = 1; i <= v; i++) {
				list[i] = new ArrayList<>();
			}
			int[] degree = new int[v + 1];
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < e; i++) {
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				list[a].add(b);
				degree[b]++;
			}
			
			Deque<Integer> deque = new ArrayDeque<>();
			for (int i = 1; i <= v; i++) {
				if (degree[i] == 0) {
					deque.addLast(i);
				}
			}
			
            sb.append("#").append(t).append(" ");
			while (!deque.isEmpty()) {
				int now = deque.pollFirst();
				sb.append(now).append(" ");
				for (int next : list[now]) {
					if (--degree[next] == 0) {
						deque.addLast(next);
					}
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}