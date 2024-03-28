import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			
			// 입력
			int n = Integer.parseInt(br.readLine());
			int[][] human = new int[10][2];
			int[][] aisle = new int[2][3];
			int man = 0;
			int idx = 0;
			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					int num = Integer.parseInt(st.nextToken());
					if (num == 1) {
						human[man][0] = i;
						human[man++][1] = j;
					} else if (num > 1) {
						aisle[idx][0] = i;
						aisle[idx][1] = j;
						aisle[idx++][2] = num;
					}
				}
			}
			
			// 경우의 수 비트마스킹
			int min = 1000;
			for (int bit = 0; bit < (1 << man); bit++) {
				ArrayList<Integer>[] list = new ArrayList[2];
				for (int i = 0; i < 2; i++) {
					list[i] = new ArrayList<>();
				}
				for (int i = 0; i < man; i++) {
					if ((bit & (1 << i)) > 0) {
						list[0].add(dist(human[i], aisle[0]));
					} else {
						list[1].add(dist(human[i], aisle[1]));
					}
				}
			
				min = Math.min(min, Math.max(times(list[0], aisle[0][2]), times(list[1], aisle[1][2])));
			}
			
			sb.append("#").append(t).append(" ").append(min).append("\n");
		}
		
		System.out.println(sb);
	}
	
	static int dist(int[] human, int[] aisle) {
		return Math.abs(human[0] - aisle[0]) + Math.abs(human[1] - aisle[1]) + 1;
	}
	
	static int times(ArrayList<Integer> list, int len) {
		int time = 0;
		int[] aisle = new int[3];
		
		while (!list.isEmpty()) {
			time++;
			for (int i = 0; i < 3; i++) {
				if (aisle[i] > 0) {
					aisle[i]--;
				}
			}
			for (int i = 0; i < list.size(); i++) {
				if (time >= list.get(i)) {
					for (int j = 0; j < 3; j++) {
						if (aisle[j] == 0) {
							aisle[j] = len;
							list.remove(i);
							i--;
							break;
						}
					}
				}
			}
		}
		
		return time + len;
	}
}