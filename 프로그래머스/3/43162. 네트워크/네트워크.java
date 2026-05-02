/*
38. 네트워크
- 저자 권장풀이시간: 60분
- 내 풀이시간: 분
- 사용 자료구조:
- 시간복잡도:
- 공간복잡도:
- 아이디어: BFS가 인접한 곳들을 가까운순서대로 전부 탐색하는거라서 사용했고, 1을 만날때마다 bfs를 호출했다.
*/

/*
1 1 0
1 1 0
0 0 1

1 1 0
1 1 1
0 1 1

1 0 1 0 0
0 1 0 0 0
1 0 1 0 0
0 0 0 1 1
0 0 0 1 1
*/

import java.util.*;

class Solution {
    
    int[][] network;
    boolean[] visited;
    int m;
    
    public int solution(int n, int[][] computers) {
        int ans = 0;
        
        // 인접행렬을 전역으로, n도 외부에서는 m으로 쓰겠다.
        network = computers;
        m = n;
        
        visited = new boolean[m];
        
        for (int i = 0; i < m; i++) {
            if (!visited[i]) {
                bfs(i);
                ans++;
            }
        }
    
        return ans;
    }
    
    void bfs(int s) {
        Deque<Integer> q = new ArrayDeque<>();
        q.addLast(s);
        visited[s] = true;
        
        while(!q.isEmpty()) {
            int now = q.removeFirst();
            for (int next = 0; next < m; next++) {
                if (network[now][next] == 1 && now != next && !visited[next]) {
                    visited[next] = true;
                    q.addLast(next);
                }
            }
        }
    }
}