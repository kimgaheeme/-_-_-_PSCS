import kotlin.math.*

class Solution {
    fun solution(numbers: IntArray, hand: String) = StringBuilder().apply {
        var left = location()
        var right = location()
        
        
        numbers.forEach { it ->
            when(it) {
                in listOf(1, 4, 7) -> {
                    append("L")
                    left.row = it / 3
                    left.column = 0
                }
                //3,6,9
                in listOf(3, 6, 9) -> {
                    append("R")
                    right.row = it / 3 -1
                    right.column = 2
                }
                //2, 5, 8, 0
                in listOf(2, 5, 8, 0) -> {
                    var num: Int
                    if(it == 0) num = 11
                    else num = it
                    
                    //거리구하기
                    var rlen = abs(1 - right.column) + abs(num / 3 - right.row) 
                    var llen = abs(1 - left.column) + abs(num / 3 - left.row)
                    
                    if(rlen > llen || ((rlen == llen) && hand == "left"))  {
                        append("L")
                        left.row = num / 3
                        left.column = 1
                    } else {
                        append("R")
                        right.row = num / 3
                        right.column = 1
                    }
                }
                
            }
        }
        
    }.toString()
}

data class location(
    var row: Int = 3,
    var column: Int = 2
)