const val MAX_VALUE = 10000001

class Solution {
    fun solution(n: Int, s: Int, a: Int, b: Int, fares: Array<IntArray>): Int {
        var answer: Int = 0
        
        //s에 대해 거리 구하기
        var sStartArr = generate(n, MAX_VALUE, s)
        //a에 대해 거리 구하기
        var aStartArr = generate(n, MAX_VALUE, a)
        //b에 대해 거리 구하기
        var bStartArr = generate(n, MAX_VALUE, b)
        repeat(n - 1) {
            fares.forEach {
                var ac = it[0] - 1
                var bc = it[1] - 1
                if(sStartArr[ac] + it[2] < sStartArr[bc]) {
                    sStartArr[bc] = sStartArr[ac] + it[2]
                }
                if(sStartArr[bc] + it[2] < sStartArr[ac]) {
                    sStartArr[ac] = sStartArr[bc] + it[2]
                }
                if(aStartArr[ac] + it[2] < aStartArr[bc]) {
                    aStartArr[bc] = aStartArr[ac] + it[2]
                }
                if(aStartArr[bc] + it[2] < aStartArr[ac]) {
                    aStartArr[ac] = aStartArr[bc] + it[2]
                }
                if(bStartArr[ac] + it[2] < bStartArr[bc]) {
                    bStartArr[bc] = bStartArr[ac] + it[2]
                }
                if(bStartArr[bc] + it[2] < bStartArr[ac]) {
                    bStartArr[ac] = bStartArr[bc] + it[2]
                }
            }
        }
        
        var min = sStartArr[a - 1] + sStartArr[b - 1]
    
        
        sStartArr.forEachIndexed { index, it ->
            var len = it+ aStartArr[index] + bStartArr[index]
            if(len < min) min = len
        }
        
        return min
    }
}


fun generate(size: Int, value: Int, start: Int): MutableList<Int> {
    return (0 until size).map { if(it == start - 1) 0 else value }.toMutableList()
}