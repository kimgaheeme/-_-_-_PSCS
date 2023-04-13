class Solution {
    fun solution(clothes: Array<Array<String>>): Int {
        var answer = 1
        
        var m = clothes.groupBy{it[1]}.toList()
        m.forEach {
            answer *= (it.second.size + 1)
        }
    
        
        return answer - 1
    }
}