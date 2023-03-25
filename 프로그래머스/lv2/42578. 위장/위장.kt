class Solution {
    fun solution(clothes: Array<Array<String>>): Int {
        var m = mutableMapOf<String, Int>()
        clothes.forEach { it -> m.put(it[1], m.getOrDefault(it[1], 0) + 1) }
        
        var answer = 1
        m.values.forEach { it -> answer *= (it + 1) }
        
        return answer - 1
    }
}