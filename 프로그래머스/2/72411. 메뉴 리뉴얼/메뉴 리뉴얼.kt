class Solution {
    
    val map = mutableMapOf<String, Int>()
    
    fun solution(orders: Array<String>, course: IntArray): Array<String> {
        
        val ans = mutableListOf<String>()
        
        for (crs in course) {
            for (order in orders) {
                comb(0, 0, crs, order, 0)
            }
            
            var maxVal = 2
            for ((k, v) in map) {
                maxVal = maxOf(v, maxVal)
            }
            for ((k, v) in map) {
                if (v == maxVal) ans.add(k)
            }
            
            map.clear()
        }
        
        ans.sort()
        return ans.toTypedArray()
    }
    
    fun comb(idx: Int, cnt: Int, crs: Int, order:String, check: Int) {
        if (cnt == crs) {
            val temp = mutableListOf<Char>()
            for (i in 0 until idx) {
                if ((1 shl i) and check != 0) temp.add(order[i])
            }
            val key = temp.sorted().joinToString("")
            map[key] = (map[key] ?: 0) + 1
            return
        }
        if (idx == order.length) return
        comb(idx + 1, cnt + 1, crs, order, check + (1 shl idx))
        comb(idx + 1, cnt, crs, order, check)
    }
}