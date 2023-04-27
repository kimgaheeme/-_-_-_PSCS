class Solution {
    fun solution(scores: Array<IntArray>): Int {
        var answer: Int = 0
        var wan = scores[0]
        scores.sortWith{ a, b ->
            if(a[0] != b[0]) b[0] - a[0]
            else  a[1] - b[1]
        }
        
        var list = mutableListOf<IntArray>()
        var max = -1
        
        scores.forEach {
            if(it[1] >= max) {
                list.add(it)
                max = it[1]
            }
            if(it[0] == wan[0] && it[1] == wan[1]) {
                if(it[1] < max) return -1
            }
        }
        
        list.forEach {
            if(it[0] + it[1] > wan[1] + wan[0] ) answer++
        }
        
        return answer + 1
    }
}
