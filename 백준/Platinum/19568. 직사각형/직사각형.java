public class Main {
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		
		int[][] arr = new int[30][30];
		for (int i = 0; i < 14; i++) {
			arr[i][14] = 1;
			arr[14][i] = 15;
		}
		for (int i = 15; i < 29; i++) {
			arr[i][14] = 15 * 15;
			arr[14][i] = 15 * 15 * 15;
		}
		
		for (int i = 0; i < 30; i++) {
			for (int j = 0; j < 30; j++) {
				sb.append(arr[i][j]).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
}