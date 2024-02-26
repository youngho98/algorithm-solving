import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	static int[] nums;
	static int n;
	static ArrayList<Integer> prints = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		nums = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		int plus = Integer.parseInt(st.nextToken());
		int minus = Integer.parseInt(st.nextToken());
		int multi = Integer.parseInt(st.nextToken());
		int div = Integer.parseInt(st.nextToken());
		
		calc(0, plus, minus, multi, div, nums[0]);
		
		Collections.sort(prints);
		System.out.println(prints.get(prints.size() - 1));
		System.out.println(prints.get(0));
	}
	
	static void calc(int idx, int plus, int minus, int multi, int div, int ans) {
		if (plus == -1 || minus == -1 || multi == -1 || div == -1) {
			return;
		}
		if (idx == n - 1) {
			prints.add(ans);
			return;
		}
		calc(idx+1, plus-1, minus, multi, div, ans+nums[idx+1]);
		calc(idx+1, plus, minus-1, multi, div, ans-nums[idx+1]);
		calc(idx+1, plus, minus, multi-1, div, ans*nums[idx+1]);
		calc(idx+1, plus, minus, multi, div-1, ans/nums[idx+1]);
	}
}