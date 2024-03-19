import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static Point[] cannon;
	static int n;
	static double[][] time;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 시작 좌표
		StringTokenizer st = new StringTokenizer(br.readLine());
		double startX = Double.parseDouble(st.nextToken());
		double startY = Double.parseDouble(st.nextToken());
	
		// 목적지 좌표
		st = new StringTokenizer(br.readLine());
		double targetX = Double.parseDouble(st.nextToken());
		double targetY = Double.parseDouble(st.nextToken());
		
		// 인간 대포 (시작점은 0, 대포는 1 ~ n, 도착점은 n + 1)
		n = Integer.parseInt(br.readLine());
		cannon = new Point[n + 2];
		cannon[0] = new Point(startX, startY);
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			cannon[i] = new Point(Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken()));
		}
		cannon[n + 1] = new Point(targetX, targetY);
		
		// 경로별 걸리는 시간 행렬
		time = new double[n + 2][n + 2];
		for (int i = 1; i < n + 2; i++) {
			time[0][i] = distance(cannon[0], cannon[i]) / 5;
		}
		for (int i = 1; i < n + 2; i++) {
			for (int j = i + 1; j < n + 2; j++) {
				double d = distance(cannon[i], cannon[j]);
				time[i][j] = time[j][i] = Math.min(Math.abs(d - 50) / 5 + 2, d / 5);
			}
		}
		
		// 다익스트라
		System.out.println(dijkstra());
	}
	
	static double distance(Point p1, Point p2) {
		return Math.sqrt((p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y) * (p1.y - p2.y));
	}
	
	static double dijkstra() {
		double[] dp = new double[n + 2];
		Arrays.fill(dp, 100_000_000);
		
		PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> (int) ((o1.t - o2.t) * 100_000));
		pq.add(new Node(0, 0));
		dp[0] = 0;
		
		while (!pq.isEmpty()) {
			Node now = pq.poll();
			if (now.p == n + 1) {
				continue;
			}
			for (int i = 1; i < n + 2; i++) {
				if (now.p != i && dp[i] > now.t + time[now.p][i]) {
					dp[i] = now.t + time[now.p][i];
					pq.add(new Node(i, dp[i]));
				}
			}
		}
		
		return dp[n + 1];
	}
}

class Point {
	double x, y;

	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}
}

class Node {
	int p;
	double t;

	public Node(int p, double t) {
		this.p = p;
		this.t = t;
	}
}