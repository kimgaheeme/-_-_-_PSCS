import kotlin.math.*

class Solution {
    fun solution(numbers: IntArray, hand: String) = StringBuilder().apply {
        var left = location()
        var right = location()
        
        
        numbers.forEach { it ->
            when(it) {
                in listOf(1, 4, 7) -> {
                    append("L")
                    left = left.copy(row = it / 3, column = 0)
                }
                //3,6,9
                in listOf(3, 6, 9) -> {
                    append("R")
                    right = left.copy(row = it / 3 - 1, column = 2)
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
                        left = left.copy(row = num / 3, column = 1)
                    } else {
                        append("R")
                        right = right.copy(row = num / 3, column = 1)
                    }
                }
                
            }
        }
        
        println(left.row)
        
    }.toString()
}

data class location(
    val row: Int = 3,
    val column: Int = 2
)