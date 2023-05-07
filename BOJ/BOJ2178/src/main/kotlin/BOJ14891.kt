import kotlin.math.*

fun main() {
    var gears = mutableListOf<Gear>()

    repeat(4) { gears.add(Gear(readln())) }

    var N = readln().toInt()
    repeat(N) {
        var input = readln().split(" ").map { it.toInt() }

        var toChange = IntArray(4){ 0 }
        toChange[input[0] - 1] = input[1]

        for(i in 0 until 4 - input[0]) {
            if(gears[i + input[0] - 1].getRight() != gears[i + input[0]].getLeft()) {
                toChange[i + input[0]] = input[1] * (-1.0).pow(i + 1).toInt()
            } else {
                break
            }
        }

        for(i in 0 until input[0] - 1) {
            if(gears[input[0] - i - 1].getLeft() != gears[input[0] - i - 2].getRight()) {
                toChange[input[0] - i - 2] = input[1] * (-1.0).pow(i + 1).toInt()
            } else {
                break
            }
        }


        toChange.forEachIndexed { index, it ->
            gears[index].rotation(it)
        }
    }

    var answer = 0
    gears.forEachIndexed { index, it ->
        answer += (it.getTop() * (2.0).pow(index).toInt())
    }

    println(answer)
}

data class Gear(
    var tooths: String,
    var nowTop: Int = 0
) {
    fun rotation(direction: Int) {
        when(direction) {
            1 -> { clockWise() }
            -1 -> { counterClockWise() }
            else -> {}
        }
    }

    private fun clockWise() {
        if(nowTop != 0) nowTop--
        else nowTop = tooths.length - 1
    }

    private fun counterClockWise() {
        if(nowTop != tooths.length - 1) nowTop++
        else nowTop = 0
    }

    fun getLeft(): Char {
        return if(nowTop - 2 >= 0) tooths[nowTop - 2]
        else tooths[nowTop + tooths.length - 2]
    }

    fun getRight(): Char {
        return if(nowTop + 2 < tooths.length) tooths[nowTop + 2]
        else tooths[nowTop - tooths.length + 2]
    }

    fun getTop(): Int {
        return tooths[nowTop].code - '0'.code
    }
}