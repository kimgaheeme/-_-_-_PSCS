class Solution {
    fun solution(a: IntArray): Int {
        var answer: Int = 0
        
        var sides = mutableListOf<Side>()
        var min = 1000000001
        
        
        for(i in 0 until a.size) {
            sides.add(Side(min, 0))
            if(min > a[i]) min = a[i]
        }
        
        min = 1000000001
        for(i in a.size - 1 downTo 0) {
            sides[i].right = min
            if(min > a[i]) min = a[i]
        }
        
        for(i in 0 until a.size) {
            if(a[i] < sides[i].left || a[i] < sides[i].right) answer++
        }
        
        return answer
    }
}

data class Side(
    var left: Int,
    var right: Int
)