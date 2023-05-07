//1 - 6, 2 - 5, 3 - 4
//  2
//4 1 3
//  5
//  6

fun main() {

    var dice = intArrayOf(1, 2, 3, 4, 5, 6)
    var diceValue = IntArray(6) { 0 }
    var (N, M, x, y, K) = readLine()!!.split(" ").map { it.toInt() }
    var array = Array(N){IntArray(M){0} }

    repeat(N) { y ->
        readLine()!!.split(" ").forEachIndexed { x, num ->  array[y][x] = num.toInt()}
    }

    readLine()!!.split(" ").forEach{
        when(it) {
            "1" -> {
                //(dice[3], dice[0], dice[2], dice[5]) = listOf(dice[5], dice[3], dice[0], dice[2])
            }
            "2" -> {

            }
            "3" -> {

            }
            "4" -> {

            }
        }
    }
}
