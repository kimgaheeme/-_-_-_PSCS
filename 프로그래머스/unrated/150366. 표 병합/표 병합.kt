class Solution {
    fun solution(commands: Array<String>): Array<String> {
        var answer: Array<String> = arrayOf<String>()
        
        var arr = mutableListOf<MutableList<Point>>()
        
        repeat(50) { x ->
            arr.add(mutableListOf<Point>())
            repeat(50) { y ->
                arr[x].add(Point(x + 1, y + 1))
            }
        }
        
        commands.forEach {
            var sarr = it.split(" ")
            
            if(sarr[0] == "UPDATE" && sarr.size == 4) {
                var realX = arr[sarr[1].toInt() - 1][sarr[2].toInt() - 1].x
                var realY = arr[sarr[1].toInt() - 1][sarr[2].toInt() - 1].y
                
                arr.forEach { arr2 ->
                    arr2.forEach { 
                        if(it.x == realX && it.y == realY){
                            it.value = sarr[3]
                        }
                    }
                }
            } else if(sarr[0] == "UPDATE" && sarr.size == 3) {
                arr.forEach { arr2 ->
                    arr2.forEach { 
                        if(it.value == sarr[1]){
                            it.value = sarr[2]
                        }
                    }
                }
            } else if(sarr[0] == "MERGE") {
                var x1 = arr[sarr[1].toInt() - 1][sarr[2].toInt() - 1].x
                var y1 = arr[sarr[1].toInt() - 1][sarr[2].toInt() - 1].y
                var x2 = arr[sarr[3].toInt() - 1][sarr[4].toInt() - 1].x
                var y2 = arr[sarr[3].toInt() - 1][sarr[4].toInt() - 1].y
                var v: String
                if(arr[sarr[1].toInt() - 1][sarr[2].toInt() - 1].value != "EMPTY") {
                    v = arr[sarr[1].toInt() - 1][sarr[2].toInt() - 1].value
                } else {
                    v = arr[sarr[3].toInt() - 1][sarr[4].toInt() - 1].value
                }
                arr.forEach { arr2 ->
                    arr2.forEach { 
                        if((it.x == x1 && it.y == y1)||(it.x == x2 && it.y == y2)) {
                            it.value = v
                            it.x = x1
                            it.y = y1
                        }
                    }
                }
            } else if(sarr[0] == "UNMERGE") {
                var realX = arr[sarr[1].toInt() - 1][sarr[2].toInt() - 1].x
                var realY = arr[sarr[1].toInt() - 1][sarr[2].toInt() - 1].y
                var v = arr[sarr[1].toInt() - 1][sarr[2].toInt() - 1].value
                println("$realX. $realY")
                arr.forEachIndexed { x, arr2 ->
                    arr2.forEachIndexed { y, it ->
                        if(it.x == realX && it.y == realY){
                            it.value = "EMPTY"
                            it.x = x + 1
                            it.y = y + 1
                        }
                    }
                }
                arr[sarr[1].toInt() - 1][sarr[2].toInt() - 1].value = v
                
            } else {
                answer += arr[sarr[1].toInt() - 1][sarr[2].toInt() - 1].value
            }
        }
       
        return answer
    }
}

data class Point(
    var x: Int = 1,
    var y: Int = 1,
    var value: String = "EMPTY"
)

fun printAll(list: MutableList<MutableList<Point>>) {
    repeat(4){ x->
        repeat(4){ y->
            print("${list[x][y]}   ")
        }
        println()
    }
    
    println()
}