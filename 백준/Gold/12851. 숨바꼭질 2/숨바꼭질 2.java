import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        Deque<Subin> deque = new ArrayDeque<>();
        int[] visited = new int[100_001];
        for (int i = 0; i < 100_001; i++) {
            visited[i] = Integer.MAX_VALUE;
        }
        deque.addLast(new Subin(n, 0));
        visited[n] = 0;
        int fastTime = 0;
        while (true) {
            Subin node = deque.pollFirst();
            int i = node.location;
            int t = node.time;

            if (i == k) {
                fastTime = t;
                break;
            }

            if (i - 1 >= 0 && visited[i - 1] >= t + 1) {
                deque.addLast(new Subin(i - 1, t + 1));
                visited[i - 1] = t + 1;
            }
            if (i + 1 <= 100_000 && visited[i + 1] >= t + 1) {
                deque.addLast(new Subin(i + 1, t + 1));
                visited[i + 1] = t + 1;
            }
            if (i * 2 <= 100_000 && visited[i * 2] >= t + 1) {
                deque.addLast(new Subin(i * 2, t + 1));
                visited[i * 2] = t + 1;
            }
        }

        int cnt = 1;
        while (!deque.isEmpty()) {
            Subin node = deque.pollFirst();
            if (node.location == k && node.time == fastTime) {
                cnt++;
            }
        }

        System.out.println(fastTime);
        System.out.println(cnt);
    }
}

class Subin {
    int location;
    int time;

    Subin(int location, int time) {
        this.location = location;
        this.time = time;
    }
}