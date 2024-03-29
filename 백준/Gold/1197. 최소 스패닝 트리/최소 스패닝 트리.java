import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        // 간선 입력
        Line[] lines = new Line[e];
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken());
            lines[i] = new Line(a, b, c);
        }

        // 짧은 간선부터 정렬
        Arrays.sort(lines, (o1, o2) -> {
            return o1.w - o2.w;
        });

        // 유니온 파인드
        parents = new int[v];
        for (int i = 0; i < v; i++) {
            parents[i] = i;
        }

        long weight = 0L;
        int cnt = 0;
        for (int i = 0; i < e; i++) {
            if (unionFind(lines[i].p1, lines[i].p2)) {
                continue;
            }
            union(lines[i].p1, lines[i].p2);
            weight += lines[i].w;
            if (cnt == v - 1) {
                break;
            }
        }

        System.out.println(weight);
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x < y) {
            parents[y] = x;
        } else if (x > y) {
            parents[x] = y;
        }
    }

    static int find(int x) {
        if (parents[x] == x) {
            return x;
        }
        return find(parents[x]);
    }

    static boolean unionFind(int x, int y) {
        if (find(x) == find(y)) {
            return true;
        }
        return false;
    }
}

class Line {
    int p1, p2, w;

    public Line(int p1, int p2, int w) {
        this.p1 = p1;
        this.p2 = p2;
        this.w = w;
    }
}