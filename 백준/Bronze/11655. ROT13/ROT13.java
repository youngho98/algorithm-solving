import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		char[] chars = br.readLine().toCharArray();
		for (char c : chars) {
			if ((65 <= c && c <= 77) || (97 <= c && c <= 109)) {
				bw.write((char) (c + 13));
			} else if ((78 <= c && c <= 90) || (110 <= c && c <= 122)) {
				bw.write((char) (c - 13));
			} else {
				bw.write((char) c);
			}
		}
		bw.flush();
		bw.close();
	}
}