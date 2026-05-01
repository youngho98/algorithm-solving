class Solution {
    
    val ref = mutableMapOf<String, String>()
    val money = mutableMapOf<String, Int>()
    
    fun solution(
        enroll: Array<String>, 
        referral: Array<String>, 
        seller: Array<String>, 
        amount: IntArray
    ): IntArray {
        
        // ref 등록 & 초기 자본 설정
        for (i in 0 until enroll.size) {
            ref[enroll[i]] = referral[i]
            money[enroll[i]] = 0
        }
        
        // 판매금액 정산
        for (i in 0 until seller.size) {
            calc(seller[i], amount[i] * 100)
        }
        
        // 최종 결과물
        val answer = IntArray(enroll.size)
        for (i in 0 until enroll.size) {
            answer[i] = money[enroll[i]]!!
        }
        return answer
    }
    
    fun calc(name: String, price: Int) {
        var nowName = name
        var nowPrice = price
        var nextPrice = 0
        while(true) {
            if (nowPrice == 0 || nowName == "-") return
            nextPrice = nowPrice / 10
            money[nowName] = money[nowName]!! + nowPrice - nextPrice
            nowName = ref[nowName]!!
            nowPrice = nextPrice
        }
    }
}