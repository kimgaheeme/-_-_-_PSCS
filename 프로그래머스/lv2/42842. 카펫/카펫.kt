class Solution {
    fun solution(brown: Int, yellow: Int): IntArray {
        var answer = intArrayOf()
        
        for(a in 1 until brown) {
            if(yellow % a == 0) {
                var b = yellow / a
                if((2 * (a + b) + 4) == brown) {
                    return intArrayOf(b + 2, a + 2)
                }
            }
            
        }
        return answer
    }
}