import kotlin.math.*

class Solution {
    fun solution(numbers: IntArray, hand: String) = StringBuilder().apply {
        var left = Pair(3,2)
        var right = Pair(3,2)
        
        var gesture = mutableListOf<Pair<Int,Int>>()
        numbers.forEach { 
            if(it == 0) gesture.add(Pair(3,1))
            else gesture.add(Pair((it - 1) / 3, (it - 1) % 3))
        }
        
        
        gesture.forEach { it ->
            when(it.second) {
                0 -> {
                    append("L")
                    left = it
                }
                2 -> {
                    append("R")
                    right = it
                }
                1 -> {
                    
                    //거리구하기
                    var rlen = abs(1 - right.second) + abs(it.first - right.first) 
                    var llen = abs(1 - left.second) + abs(it.first - left.first)
                    
                    if(rlen > llen || ((rlen == llen) && hand == "left"))  {
                        append("L")
                        left = it
                    } else {
                        append("R")
                        right = it
                    }
                }
                
            }
        }
        
    }.toString()
}

