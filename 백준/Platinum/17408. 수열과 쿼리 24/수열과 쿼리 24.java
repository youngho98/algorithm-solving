import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	
	static int height;
	static int startIdx;
	static int[][] tree;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// 트리의 높이 구하기
		int n = Integer.parseInt(br.readLine());
		while ((1 << height) < n) {
			height++;
		}
		
		// 트리 생성
		tree = new int[1 << (height + 1)][2];
		startIdx = 1 << height;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = startIdx; i < startIdx + n; i++) {
			tree[i][0] = Integer.parseInt(st.nextToken());
		}
		
		setTree();
		
		// 쿼리문 실행
		int m = Integer.parseInt(br.readLine());
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int cmd = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if (cmd == 1) {
				changeVal(a, b);
			} else {
				sb.append(findMax(a, b)).append("\n");
			}
		}
		
		System.out.println(sb);
	}

	static void setTree() {
		for (int i = startIdx - 1; i > 0; i--) {
			int[] arr = new int[4];
			arr[0] = tree[i * 2][0];
			arr[1] = tree[i * 2][1];
			arr[2] = tree[i * 2 + 1][0];
			arr[3] = tree[i * 2 + 1][1];
			Arrays.sort(arr);
			
			tree[i][0] = arr[3];
			tree[i][1] = arr[2];
		}
	}
	
	static int findMax(int left, int right) {
		left += startIdx - 1;
		right += startIdx - 1;
		
		ArrayList<Integer> list = new ArrayList<>();
		while (left <= right) {
			if ((left & 1) == 1) {
				list.add(tree[left][0]);
				list.add(tree[left][1]);
				left++;
			}
			if ((right & 1) == 0) {
				list.add(tree[right][0]);
				list.add(tree[right][1]);
				right--;
			}
			left >>= 1;
			right >>= 1;
		}
		
		Collections.sort(list, Collections.reverseOrder());
		
		return list.get(0) + list.get(1);
	}
	
	static void changeVal(int idx, int val) {
		idx += startIdx - 1;
		tree[idx][0] = val;
		idx >>= 1;
		
		while (idx > 0) {
			int[] arr = new int[4];
			arr[0] = tree[idx * 2][0];
			arr[1] = tree[idx * 2][1];
			arr[2] = tree[idx * 2 + 1][0];
			arr[3] = tree[idx * 2 + 1][1];
			Arrays.sort(arr);
			
			tree[idx][0] = arr[3];
			tree[idx][1] = arr[2];
			idx >>= 1;
		}
	}
}