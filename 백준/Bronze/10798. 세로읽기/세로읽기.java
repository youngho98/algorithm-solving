import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[][] graph = new char[5][15];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 15; j++) {
                graph[i][j] = '*';
            }
        }
        for (int i = 0; i < 5; i++) {
            String line = br.readLine();
            for (int j = 0; j < line.length(); j++) {
                graph[i][j] = line.charAt(j);
            }
        }

        for (int j = 0; j < 15; j++) {
            for (int i = 0; i < 5; i++) {
                if (graph[i][j] == '*') {
                    continue;
                }
                System.out.print(graph[i][j]);
            }
        }
    }
}