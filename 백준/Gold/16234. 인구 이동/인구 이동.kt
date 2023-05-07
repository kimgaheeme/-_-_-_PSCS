import java.util.*
import kotlin.math.*

fun main() {
    var input = readLine()!!.split(" ").map { it.toInt() }
    var N = input[0]
    var L = input[1]
    var R = input[2]
    var answer = 0

    var dy = listOf(1, 0, -1, 0)
    var dx = listOf(0, 1, 0, -1)


    var array = Array(N) {IntArray(N){0} }
    var visited = Array(N) {BooleanArray(N){ false } }
    var visited2 = Array(N) {BooleanArray(N){ false } }
    repeat(N) {x ->
        readLine()!!.split(" ").mapIndexed{ y, it -> array[x][y] = it.toInt() }
    }

    var visitedCount = 0
    var now = Pair(0, 0)
    var queue = LinkedList<Pair<Int, Int>>()
    var list = LinkedList<Pair<Int, Int>>()
    var sum = 0

    while (answer <= 2000) {
        var isChanged = false

        while(true) {
            sum = 0
            for(x in now.first until N) {
                for(y in now.second until N) {
                    if(!visited[x][y] && !visited2[x][y]) {
                        queue.add(Pair(x, y))
                        visited[x][y] = true
                        visited2[x][y] = true
                        break
                    }
                }
                if(queue.size != 0) break
            }
            if(queue.size == 0) break;

            while(queue.isNotEmpty()) {
                var current = queue.pop()
                visitedCount++
                list.add(Pair(current.first, current.second))
                sum += array[current.first][current.second]

                repeat(4) {
                    var newX = current.first + dx[it]
                    var newY = current.second + dy[it]
                    if(newX in 0 until N && newY in 0 until N && !visited[newX][newY]) {
                        var diff = abs(array[newX][newY] - array[current.first][current.second])
                        if(diff in L .. R) {
                            queue.add(Pair(newX, newY))
                            visited[newX][newY] = true
                            visited2[newX][newY] = true
                        }
                    }
                }
            }
            if(list.size != 1) { isChanged = true }


            var newValue = sum / list.size

            if(list.size != 1) {
                while(list.size != 0) {
                    var n = list.pop()
                    visited2[n.first][n.second] = false
                    array[n.first][n.second] = newValue
                }
            }else {
                list.pop()
            }
        }

        if(!isChanged){println(answer); break}
        else answer++

        visitedCount = 0
        visited = Array(N) {BooleanArray(N){ false } }

    }

}