import kotlin.math.*


lateinit var seat : MutableList<IntArray>
var size = 0
fun main() {
    size = readLine()!!.split(" ")[0].toInt()
    var want = mutableMapOf<Int, List<Int>>()
    var sequence = mutableListOf<Int>()

    repeat(size * size) {
        var line = readLine()!!.split(" ")
        sequence.add(line[0].toInt())
        //println(line)
        want.put(line[0].toInt(), line.subList(1, line.size) .map { it.toInt() })
    }

    seat = MutableList<IntArray>(size) { IntArray(size){0} }

    sequence.forEach {

        var point = Pair(0, 0)
        var wantCount = -1
        var emptyCount = -1
        repeat(size){x ->
            repeat(size) {y ->
                if(seat[x][y] == 0) {
                    var count = countWant(want[it]?: emptyList(), x, y)
                    var empty = countEmpty(x, y)
                    if(count > wantCount) {
                        point = Pair(x, y)
                        wantCount = count
                        emptyCount = empty
                    } else if(count == wantCount && empty > emptyCount) {
                        point = Pair(x, y)
                        wantCount = count
                        emptyCount = empty
                    }

                }
            }

        }
        seat[point.first][point.second] = it
    }

    var answer = 0

    seat.forEachIndexed{ x , list->
        list.forEachIndexed { y , it ->
            answer += getSatisfy(countWant(want[it]!!, x, y))
        }
    }
    print(answer)
}

var dx = listOf<Int>(-1, 0, 1, 0)
var dy = listOf<Int>(0, 1, 0, -1)

fun countWant(want: List<Int>, seatX: Int, seatY: Int): Int {
    var answer = 0

    repeat(4) {
        var nowX = seatX + dx[it]
        var nowY = seatY + dy[it]
        if(nowX in 0 until size && nowY in 0 until size) {
            if(want.contains(seat[nowX][nowY])) answer ++
        }
    }

    return answer
}

fun countEmpty(seatX: Int, seatY: Int): Int {
    return countWant(emptyList(), seatX, seatY)
}

fun getSatisfy(i: Int): Int {
    return if(i == 0) 0
    else (10.0).pow(i - 1).toInt()
}