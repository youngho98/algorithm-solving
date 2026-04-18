class Solution {
    fun solution(n: Int, left: Long, right: Long): IntArray {
        var answer: IntArray = IntArray((right - left).toInt() + 1)
        for (i in left..right) {
            answer[(i - left).toInt()] = Math.max(i / n, i % n).toInt() + 1
        }
        return answer
    }
}