import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String t = br.readLine();
		String p = br.readLine();
		
		int[] pi = getPi(p);
		
		ArrayList<Integer> ans = new ArrayList<>();
		int j = 0;
		for (int i = 0; i < t.length(); i++) {
			while (j > 0 && t.charAt(i) != p.charAt(j)) {
				j = pi[j - 1];
			}
			if (t.charAt(i) == p.charAt(j)) {
				if (j == p.length() - 1) {
					ans.add(i - p.length() + 2);
					j = pi[j];
				} else {
					j++;
				}
			}
		}
		
		sb.append(ans.size()).append("\n");
		for (int i : ans) {
			sb.append(i).append(" ");
		}
		
		System.out.println(sb);
	}
	
	static int[] getPi(String p) {
		int[] pi = new int[p.length()];
		
		int j = 0;
		for (int i = 1; i < p.length(); i++) {
			while (j > 0 && p.charAt(i) != p.charAt(j)) {
				j = pi[j - 1];
			}
			if (p.charAt(i) == p.charAt(j)) {
				pi[i] = ++j;
			}
		}
		
		return pi;
	}
}