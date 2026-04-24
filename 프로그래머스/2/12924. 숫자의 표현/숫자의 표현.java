// i * (s + l) / 2 == n;
// i * (s + l) = 2 * n;
// i가 2n의 약수여야 한다.

// 어떤 숫자 a 부터 i개의 숫자를 더한 합은?
// (2 * a + i - 1) * i / 2 = n

class Solution {
    public int solution(int n) {
        int answer = 0;
        for (int i = 1; i * (i + 1) / 2 <= n; i++) {
            if ((i & 1) == 1 && n % i == 0) answer++;
            else if ((i & 1) == 0 && (2 * n) % i == 0 && (2 * n / i) % 2 == 1) answer++;
        }
        return answer;
    }
}