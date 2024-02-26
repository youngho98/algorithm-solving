import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	
	static ArrayList<Integer>[] tree;
	static int[] apple;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		// 트리 입력
		tree = new ArrayList[n];
		for (int i = 0; i < n; i++) {
			tree[i] = new ArrayList<>();
		}
		for (int i = 0; i < n - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			tree[a].add(b);
			tree[b].add(a);
		}
		// 사과 수 입력
		st = new StringTokenizer(br.readLine());
		apple = new int[n];
		for (int i = 0; i < n; i++) {
			apple[i] = Integer.parseInt(st.nextToken());
		}
		// bfs 탐색
		visited = new boolean[n];
		visited[0] = true;
		System.out.println(bfs(0, k));
	}
	
	static int bfs(int node, int k) {
		int cnt = 0;
		if (apple[node] == 1) {
			cnt++;
		}
		Deque<Node> deque = new ArrayDeque<>();
		deque.addLast(new Node(node, 0));
		while (!deque.isEmpty()) {
			Node now = deque.pollFirst();
			if (now.depth == k) {
				continue;
			}
			for (int next : tree[now.value]) {
				if (visited[next]) {
					continue;
				}
				visited[next] = true;
				if (apple[next] == 1) {
					cnt++;
				}
				deque.addLast(new Node(next, now.depth + 1));
			}
		}
		return cnt;
	}
}

class Node {
	
	int value, depth;

	public Node(int value, int depth) {
		this.value = value;
		this.depth = depth;
	}
}