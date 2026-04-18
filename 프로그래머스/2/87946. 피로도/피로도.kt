class Solution {
    
    var answer = -1
    
    fun solution(k: Int, dungeons: Array<IntArray>): Int {
        explore(k, 0, dungeons, 0)
        return answer
    }
    
    fun explore(energy: Int, count: Int, dungeons: Array<IntArray>, visited: Int) {
        if (count > answer) answer = count
        for (i in 0 until dungeons.size) {
            if ((visited and (1 shl i)) > 0) continue
            if (dungeons[i][0] > energy) continue
            explore(energy - dungeons[i][1], count + 1, dungeons, visited + (1 shl i))
        }
    }
}