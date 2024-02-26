import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] chars = br.readLine().toCharArray();
        int[] alphabet = new int[26];
        for (char c : chars) {
            alphabet[c - 97]++;
        }
        for (int i : alphabet) {
            System.out.print(i + " ");
        }
    }
}