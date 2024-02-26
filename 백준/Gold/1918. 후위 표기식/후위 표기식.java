import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 후위 표기식으로 바꾸기
		StringBuilder post = new StringBuilder();
		String str = "("+br.readLine()+")";
		char[] ch = str.toCharArray();
		Deque<Character> oper = new ArrayDeque<>(); // 연산자 스택

		for (int i = 0; i < ch.length; i++) {
			if ('A' <= ch[i] && ch[i] <= 'Z') {
				post.append(ch[i]);
			} else if (ch[i] == '(') {
				oper.addLast(ch[i]);
			} else if (ch[i] == ')') {
				while (!oper.isEmpty() && oper.peekLast() != '(') {
					post.append(oper.pollLast());
				}
				oper.pollLast();
			} else {
				while (!oper.isEmpty() && priority(ch[i]) <= priority(oper.peekLast())) {
					post.append(oper.pollLast());
				}
				oper.addLast(ch[i]);
			}
		}

		// 출력
		System.out.println(post);
	}

	// 연산자 우선순위
	static int priority(char c) {
		switch (c) {
		case '+':
		case '-':
			return 1;
		case '*':
		case '/':
			return 2;
		default:
			return 0;
		}
	}
}