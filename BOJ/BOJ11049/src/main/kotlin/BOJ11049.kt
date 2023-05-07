import java.util.Queue
import java.util.LinkedList

val way = arrayOf(Pair(1, 0), Pair(-1, 0), Pair(0, -1), Pair(0, 1))

fun main() {
    var input = readLine()!!.split(" ")
    var row = input[0].toInt()
    var col = input[1].toInt()

    var roadArray = Array(row) { Array (col) { false } }
    var visitArray = Array(row) { Array (col) { false } }


    repeat(row) { i ->
        var input = readLine()!!
        input.forEachIndexed{ j, it ->
            if(it == '1') roadArray[i][j] = true
        }
    }

    var answer = 1

    var queue: Queue<Pair<Int, Int>> = LinkedList()
    queue.add(Pair(0, 0))
    visitArray[0][0] = true

    while(queue.isNotEmpty()) {
        var size = queue.size

        repeat(size){
            way.forEach {

                var i = queue.peek().first + it.first
                var j = queue.peek().second + it.second
                if(i == row - 1 && j == col - 1) {
                    println(answer + 1)
                    return
                }
                else if(i in 0 until row && j in 0 until col) {
                    if(!visitArray[i][j] && roadArray[i][j]) {
                        visitArray[i][j] = true
                        queue.add(Pair(i, j))
                    }
                }
            }
            queue.poll()
        }
        answer++
    }

}
