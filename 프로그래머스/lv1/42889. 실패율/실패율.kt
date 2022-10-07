class Solution {
    fun solution(N: Int, stages: IntArray): List<Int> {
        
        var count = stages.size.toFloat()
        
        val tL = mutableMapOf<Int,Float>()
        
        repeat(N) { idx ->
            var c = stages.count({it == (idx+1)})
            
            if(c > 0) tL[idx + 1] = c / count
            else tL[idx + 1] = 0.0f
            count -= c   
        }
        
        println(tL)
        
        return tL
            .toList()
            .sortedByDescending { it.second }
            .toMap()
            .keys
            .toList()
    }
}