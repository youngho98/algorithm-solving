import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		HashSet<Character> set = new HashSet<>();
		set.add('a');
		set.add('e');
		set.add('i');
		set.add('o');
		set.add('u');
		set.add('A');
		set.add('E');
		set.add('I');
		set.add('O');
		set.add('U');
		
		while (true) {
			String s = br.readLine();
			if (s.equals("#")) {
				break;
			}
			int cnt = 0;
			for (int i = 0; i < s.length(); i++) {
				if (set.contains(s.charAt(i))) {
					cnt++;
				}
			}
			sb.append(cnt).append("\n");
		}
		
		System.out.println(sb);
	}
}