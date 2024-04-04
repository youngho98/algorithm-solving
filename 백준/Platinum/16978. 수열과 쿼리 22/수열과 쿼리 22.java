import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	
	static int height;
	static int startIdx;
	static long[] tree;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// 트리의 높이 구하기
		int n = Integer.parseInt(br.readLine());
		height = 0;
		while ((1 << height) < n) {
			height++;
		}
		
		// 트리 생성
		tree = new long[1 << (height + 1)];
		startIdx = 1 << height;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = startIdx; i < startIdx + n; i++) {
			tree[i] = Integer.parseInt(st.nextToken());
		}
		
		setTree();
		
		// 쿼리문 입력
		int m = Integer.parseInt(br.readLine());
		int queryIdx1 = 1;
		int queryIdx2 = 0;
		int[][] query1 = new int[m][];
		ArrayList<int[]> query2 = new ArrayList<>();
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int cmd = Integer.parseInt(st.nextToken());
			if (cmd == 1) {
				int idx = Integer.parseInt(st.nextToken());
				int val = Integer.parseInt(st.nextToken());
				query1[queryIdx1++] = new int[] {idx, val};
			} else {
				int num = Integer.parseInt(st.nextToken());
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				query2.add(new int[] {num, start, end, queryIdx2});
				queryIdx2++;
			}
		}
		
		// 쿼리문 실행
		Collections.sort(query2, (o1, o2) -> o1[0] - o2[0]);
		int nowQuery1 = 0;
		long[] answer = new long[queryIdx2];
		for (int[] q2 : query2) {
			while (q2[0] > nowQuery1) {
				nowQuery1++;
				changeVal(query1[nowQuery1][0], query1[nowQuery1][1]);
			}
			answer[q2[3]] = getSum(q2[1], q2[2]);
		}
		
		// 출력
		for (long ans : answer) {
			sb.append(ans).append("\n");
		}
		
		System.out.println(sb);
	}
	
	static void setTree() {
		for (int i = startIdx - 1; i > 0; i--) {
			tree[i] = tree[i * 2] + tree[i * 2 + 1];
		}
	}
	
	static void changeVal(int idx, int val) {
		idx += startIdx - 1;
		long diff = val - tree[idx];
		while (idx > 0) {
			tree[idx] += diff;
			idx >>= 1;
		}
	}
	
	static long getSum(int start, int end) {
		start += startIdx - 1;
		end += startIdx - 1;
		
		long sum = 0L;
		while (start <= end) {
			if ((start & 1) == 1) {
				sum += tree[start];
				start++;
			}
			if ((end & 1) == 0) {
				sum += tree[end];
				end--;
			}
			start >>= 1;
			end >>= 1;
		}
		return sum;
	}
}