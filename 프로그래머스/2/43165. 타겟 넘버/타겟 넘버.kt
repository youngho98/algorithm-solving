class Solution {
    
    lateinit var nums: IntArray
    var ans = 0
    var t = 0
    
    fun solution(numbers: IntArray, target: Int): Int {
        nums = numbers
        t = target
        calc(0, 0)
        return ans
    }
    
    fun calc(idx: Int, num: Int) {
        if (idx == nums.size) {
            if (num == t) ans++
            return
        }
        calc(idx + 1, num + nums[idx])
        calc(idx + 1, num - nums[idx])
    }
}