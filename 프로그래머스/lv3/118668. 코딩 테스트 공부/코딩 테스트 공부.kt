import kotlin.math.*
class Solution {
    fun solution(alp: Int, cop: Int, problems: Array<IntArray>): Int {
        var alp_max = 0
        var cop_max = 0
        
        problems.forEach {
            if(it[0] > alp_max) alp_max = it[0]
            if(it[1] > cop_max) cop_max = it[1]
        }
        
        var alp_2 = min(alp, alp_max)
        var cop_2 = min(cop, cop_max)
        
        var dp = Array(alp_max + 1) { IntArray(cop_max + 1) { Int.MAX_VALUE } }
        dp[alp_2][cop_2] = 0
        
        
        for(i in alp_2..alp_max) {
            for(j in cop_2..cop_max) {
                if(i + 1 <= alp_max) {
                    dp[i + 1][j] = min(dp[i + 1][j], dp[i][j] + 1)
                }
                if(j + 1 <= cop_max) {
                    dp[i][j + 1] = min(dp[i][j + 1], dp[i][j] + 1)
                }
                
                problems.forEach {
                    if(it[0] <= i && it[1] <= j) {
                        var a = min(i + it[2], alp_max)
                        var b = min(j + it[3], cop_max)
                        dp[a][b] = min(dp[a][b], dp[i][j] + it[4])
                    }
                   
                }
            }
        }
        
        
        return dp[alp_max][cop_max]
    }
    
}