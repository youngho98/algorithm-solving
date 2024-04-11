import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		HashMap<String, Integer> dict = new HashMap<>(); // 단어로 id 검색
		String[] word = new String[100001]; // id로 단어 검색
		int[][] count = new int[100001][2]; // {id, cnt}
		
		int id = 0;
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			if (str.length() < m) {
				continue;
			}
			if (dict.keySet().contains(str)) {
				count[dict.get(str)][1]++;
			} else {
				dict.put(str, id);
				word[id] = str;
				count[id] = new int[] {id, 1};
				id++;
			}
		}
		
		Arrays.sort(count, (o1, o2) -> o2[1] - o1[1]);
		
		ArrayList<String> temp = new ArrayList<>();
		int freq = count[0][1];
		int idx = 0;
		while (idx <= id) {
			if (count[idx][1] != freq) {
				temp.sort((o1, o2) -> {
					if (o1.length() == o2.length()) {
						return o1.compareTo(o2);
					}
					return o2.length() - o1.length();
				});
				for (String s : temp) {
					sb.append(s).append("\n");
				}
				
				temp.clear();
				freq = count[idx][1];
			}
			temp.add(word[count[idx][0]]);
			idx++;
		}
		
		System.out.println(sb);
	}
}