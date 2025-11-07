import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        
        // 이차원 배열로 이렇게 만들 수도 있어
        int[][] ans = {{1, 2, 3, 4, 5}, 
                       {2, 1, 2, 3, 2, 4, 2, 5}, 
                       {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}};

        // cnt도 배열로 만들면
        int[] cnt = new int[3];

        // 이렇게 반복문으로 처리 가능
        for(int i = 0; i < answers.length; i++) {
            for (int k = 0; k < 3; k++) { // i랑 j랑은 비슷해서 헷갈릴까봐 k로 씀
                // ans[k].length로 학생마다 몇개를 기준으로 반복해서 찍는지 알 수 있어
                if (answers[i] == ans[k][i % ans[k].length]) cnt[k]++;
            }
        }

        // Math.max 안쓰고 if문으로도 max값 구할 수 있어
        int max = 0;
        for (int k = 0; k < 3; k++) {
            if (cnt[k] > max) max = cnt[k];
        }
        
        // 정답은 이렇게 오름차순으로 반복문 돌면서 리스트에다 담아요
        ArrayList<Integer> list = new ArrayList<>();
        for (int k = 0; k < 3; k++) {
            if (cnt[k] == max) list.add(k + 1); // 인덱스인 k는 0부터 시작하지만 학생은 1부터 시작하니 k + 1
        }
        
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}