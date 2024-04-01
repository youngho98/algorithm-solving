import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static long[] tree;
	static int height;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		// 세그먼트 트리 생성 & 입력
		height = 0;
		while ((1<<height) < n) {
			height++;
		}
		
		tree = new long[1<<(height + 1)];
		for (int i = (1<<height); i < (1<<height) + n; i++) {
			tree[i] = Long.parseLong(br.readLine());
		}
		
		// 세그먼트 트리 채우기
		setTree();
		
		// 연산 실행
		for (int i = 0; i < m + k; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			long c = Long.parseLong(st.nextToken());
			
			if (a == 1) {
				changeVal(b, c);
			} else {
				sb.append(getSum(b, (int)c)).append("\n");
			}
		}
		
		// 출력
		System.out.println(sb);
	}

	static void setTree() {
		for (int i = (1<<height) - 1; i > 0; i--) {
			tree[i] = tree[i * 2] + tree[i * 2 + 1];
		}
	}
	
	static long getSum(int start, int end) {
		start += (1<<height) - 1;
		end += (1<<height) - 1;
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
	
	static void changeVal(int index, long val) {
		index += (1<<height) - 1;
		long change = val - tree[index];
		while (index > 0) {
			tree[index] += change;
			index >>= 1;
		}
	}
}