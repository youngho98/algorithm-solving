import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		// n, k 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		// 배열 입력
		ArrayList<Integer> list = new ArrayList<>();
		int[] arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			if (arr[i] == 1) {
				list.add(i);
			}
		}
		// 라이언 k개가 안되면 -1
		if (list.size() < k) {
			System.out.println(-1);
			return; 
		}
		
		int min = Integer.MAX_VALUE;
		for (int i = 0; i + k - 1 < list.size(); i++) {
			min = Math.min(list.get(i + k - 1) - list.get(i) + 1, min);
		}
		System.out.println(min);
	}
}