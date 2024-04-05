import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		PriorityQueue<Alphabet> pq = new PriorityQueue<>((o1, o2) -> {
			if (o1.ch == o2.ch) {
				int len = Math.min(o1.next.length(), o2.next.length());
				for (int i = 0; i < len; i++) {
					if (o1.next.charAt(i) < o2.next.charAt(i)) {
						return -1;
					} else if (o1.next.charAt(i) > o2.next.charAt(i)) {
						return 1;
					}
				}
				if (o1.next.length() > o2.next.length()) {
					return -1;
				} else {
					return 1;
				}
			}
			return o1.ch - o2.ch;
		});
		
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			pq.add(new Alphabet(s.charAt(0), s.substring(1)));
		}
		
		while (!pq.isEmpty()) {
			Alphabet now = pq.poll();
			if (now.next.length() > 1) {
				sb.append(now.ch);
				pq.add(new Alphabet(now.next.charAt(0), now.next.substring(1)));
			} else if (now.next.length() > 0) {
				sb.append(now.ch);
				pq.add(new Alphabet(now.next.charAt(0), ""));
			} else {
				sb.append(now.ch);
			}
		}
		
		System.out.println(sb);
	}
}

class Alphabet {
	char ch;
	String next;
	
	public Alphabet(char ch, String next) {
		this.ch = ch;
		this.next = next;
	}
}