class Solution {
    fun solution(brown: Int, yellow: Int): IntArray {
        var answer = intArrayOf()
        var apb = (brown - 4) /2
        
        for( b in 1 .. 2000000) {
            if(yellow % b == 0) {
                var a = yellow / b
                
                if(a + b == apb) return intArrayOf(a + 2,b + 2)
            }
            
        }
        return answer
    }
}