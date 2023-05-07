import kotlin.math.*

fun main() {
    var N = readln().toInt()
    var array = readln().split(" ").map { it.toInt() }.sorted()
    var diffs = mutableListOf<Int>()
    for(i in 0 until array.size - 1) { diffs.add(array[i + 1] - array[i]) }
    var sum = diffs[diffs.size - 1] - diffs[0]

    var diffs2 = mutableListOf(sum)
    for(i in 1 until N / 2) {
        sum -= (diffs[i - 1] + diffs[diffs.size - i])
        diffs2.add(sum)
    }

    var diff3 = mutableListOf<Int>()
    var s = 0
    for(i in 0 until diffs2.size - 1) { diff3.add((s + diffs2[i]) % 1000000007) }

    var answer = 0

    var num = sum
    for(i in 1 .. N / 2) {
        answer += (diff3[i - 1] * ((2.0).pow(i - 1) + (2.0).pow(diffs.size - i)).toInt() )
        answer %= 1000000007
    }

//    if(N % 2 != 0) {
//        answer += (diff3.last() * ((2.0).pow(N - 1).toInt() )
//        answer %= 1000000007
//    }
}