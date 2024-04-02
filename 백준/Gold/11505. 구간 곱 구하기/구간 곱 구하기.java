import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int height;
	static int startIdx;
	static long[] tree;
	static final int div = 1_000_000_007;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		// 트리 사이즈 구하기
		while ((1 << height) < n) {
			height++;
		}
		tree = new long[1 << (height + 1)];
		Arrays.fill(tree, 1);
		
		// 트리 입력
		startIdx = 1 << height;
		for (int i = startIdx; i < startIdx + n; i++) {
			tree[i] = Integer.parseInt(br.readLine());
		}
		
		// 트리 채우기
		setTree();
		
		// 명령 실행
		for (int i = 0; i < m + k; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			if (a == 1) {
				changeVal(b, c);
			} else {
				sb.append(getProd(b, c)).append("\n");
			}
		}
		
		System.out.println(sb);
	}
	
	static void setTree() {
		for (int i = startIdx - 1; i > 0; i--) {
			tree[i] = (tree[2 * i] * tree[2 * i + 1]) % div;
		}
	}
	
	static void changeVal(int idx, int val) {
		idx += startIdx - 1;
		tree[idx] = val;
		idx >>= 1;
		
		while (idx > 0) {
			tree[idx] = (tree[2 * idx] * tree[2 * idx + 1]) % div;
			idx >>= 1;
		}
	}
	
	static int getProd(int start, int end) {
		start += startIdx - 1;
		end += startIdx - 1;
		long prod = 1L;
		while (start <= end) {
			if ((start & 1) == 1) {
				prod *= tree[start];
				prod %= div;
				start++;
			}
			if ((end & 1) == 0) {
				prod *= tree[end];
				prod %= div;
				end--;
			}
			start >>= 1;
			end >>= 1;
		}
		return (int) prod;
	}
}