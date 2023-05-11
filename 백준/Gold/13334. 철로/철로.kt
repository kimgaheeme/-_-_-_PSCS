import java.util.*

fun main() {
    var commuters = mutableListOf<Pair<Int, Int>>()
    repeat(readln().toInt()) {
        var input = readln().split(" ").map { it.toInt() }
        if(input[0] < input[1]) commuters.add(Pair(input[0], input[1]))
        else commuters.add(Pair(input[1], input[0]))
    }

    commuters.sortWith(compareBy({it.second},{it.first}))

    var d = readln().toInt()
    var max = 0
    var end = 0

    var queue = PriorityQueue<Pair<Int, Int>>(compareBy { it.first })

    for(i in 0 until commuters.size) {
        if(commuters[i].second - commuters[i].first <= d) {
            end = commuters[i].second
            queue.add(commuters[i])

            while(queue.size != 0 && end - queue.first().first > d) {
                queue.poll()
            }

            if(max < queue.size) max = queue.size

        }
    }

    println(max)
}