class Solution {
    fun solution(n: Int, lost: IntArray, reserve: IntArray): Int {
        var answer = n - lost.size
        var m = mutableMapOf<Int, MutableList<Int>>()
        var re = reserve.toMutableList()
        var lostlist = mutableListOf<Int>()
        
        lost.forEach {
            if(re.contains(it)) {
                answer++
                re.removeIf{num -> num == it}
            } else {
                lostlist.add(it)
            }
        }
        
        var lo = lostlist.sorted()
        
        lo.forEach {
            if(re.contains(it - 1)) {
                answer++
            }
            else if(re.contains(it + 1)) {
                answer++
                re.removeIf{num -> num == it + 1}
            }
        }
        
        
        return answer
    }
}