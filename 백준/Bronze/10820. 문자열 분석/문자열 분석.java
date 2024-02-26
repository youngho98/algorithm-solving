import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = br.readLine()) != null) {
            char[] chars = str.toCharArray();
            int lowerCase = 0;
            int upperCase = 0;
            int number = 0;
            int space = 0;
            for (char c : chars) {
                if ('a' <= c && c <= 'z') {
                    lowerCase++;
                } else if ('A' <= c && c <= 'Z') {
                    upperCase++;
                } else if ('0' <= c && c <= '9') {
                    number++;
                } else if (c == ' ') {
                    space++;
                }
            }
            System.out.println(lowerCase + " " + upperCase + " " + number + " " + space);
        }
    }
}