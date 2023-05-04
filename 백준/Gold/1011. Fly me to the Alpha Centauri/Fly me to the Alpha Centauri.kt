import kotlin.math.*

fun main() {
    var N = readln().toInt()

    repeat(N) {
        var nums = readln().split(" ").map { it.toInt() }
        println(getNum(nums[1] - nums[0]))
    }

}

fun getNum(diff: Int): Int {
    var m = sqrt(diff.toFloat()).toInt()

    return if(m * m == diff) 2 * m - 1
    else if(m * m + m >= diff) 2 * m
    else 2 * m  + 1
}

