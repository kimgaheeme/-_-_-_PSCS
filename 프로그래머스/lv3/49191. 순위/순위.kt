//이김 -> 1 짐 -> -1 모름 -> 0

class Solution {
    fun solution(n: Int, results: Array<IntArray>): Int {
        var answer = 0
        var link = Array(n + 1){ IntArray(n + 1){0} }
        
        results.forEach {
            link[it[0]][it[1]] = 1
            link[it[1]][it[0]] = -1
        }
        
        for(k in 1..n) {
            for(i in 1..n) {
                for(j in 1..n) {
                    if(i != k && j != k) {
                        var result = link[i][k] * link[k][j]
                        if(result == 1) {
                            link[i][j] = link[i][k]
                        }
                    }
                }
            }
        }
        
        link.forEach {
            var count = 0
            it.forEach{ num ->
                if(num != 0) count++
            }
            if(count == n - 1) answer++
        }
        
        return answer
    }
}