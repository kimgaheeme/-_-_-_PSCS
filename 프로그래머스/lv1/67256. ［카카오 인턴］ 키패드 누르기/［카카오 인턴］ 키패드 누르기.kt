import kotlin.math.*

class Solution {
    fun solution(numbers: IntArray, hand: String) = StringBuilder().apply {
        var left = Pair(3,2)
        var right = Pair(3,2)
        
        
        numbers.forEach { it ->
            when(it) {
                in listOf(1, 4, 7) -> {
                    append("L")
                    left = Pair(it / 3, 0)
                }
                //3,6,9
                in listOf(3, 6, 9) -> {
                    append("R")
                    right = Pair(it / 3 - 1, 2)
                }
                //2, 5, 8, 0
                in listOf(2, 5, 8, 0) -> {
                    var num: Int
                    if(it == 0) num = 11
                    else num = it
                    
                    //거리구하기
                    var rlen = abs(1 - right.second) + abs(num / 3 - right.first) 
                    var llen = abs(1 - left.second) + abs(num / 3 - left.first)
                    
                    if(rlen > llen || ((rlen == llen) && hand == "left"))  {
                        append("L")
                        left = Pair(num / 3, 1)
                    } else {
                        append("R")
                        right = Pair(num / 3, 1)
                    }
                }
                
            }
        }
        
    }.toString()
}

