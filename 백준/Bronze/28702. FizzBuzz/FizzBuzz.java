import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine();
        String s2 = br.readLine();
        String s3 = br.readLine();

        int num = 0;
        if (!s1.equals("Fizz") && !s1.equals("Buzz") && !s1.equals("FizzBuzz")) {
            num = Integer.parseInt(s1) + 3;
        } else if (!s2.equals("Fizz") && !s2.equals("Buzz") && !s2.equals("FizzBuzz")) {
            num = Integer.parseInt(s2) + 2;
        } else if (!s3.equals("Fizz") && !s3.equals("Buzz") && !s3.equals("FizzBuzz")) {
            num = Integer.parseInt(s3) + 1;
        }

        if (num % 15 == 0) {
            System.out.println("FizzBuzz");
        } else if (num % 5 == 0) {
            System.out.println("Buzz");
        } else if (num % 3 == 0) {
            System.out.println("Fizz");
        } else {
            System.out.println(num);
        }
    }
}
