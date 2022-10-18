class Solution {
    fun solution(s: String): List<Int>  = s.substring(2,s.length-2)
            .split("},{",",")
            .toList()
            .groupingBy{it.toInt()}
            .eachCount()
            .toList()
            .sortedByDescending { it.second }
            .toMap()
            .keys
            .toList()

}