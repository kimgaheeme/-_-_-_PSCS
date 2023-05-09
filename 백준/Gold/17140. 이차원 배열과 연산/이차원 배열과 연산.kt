fun main() {
    var (r, c, k) = readln().split(" ").map { it.toInt() }
    var array = Array(100){ IntArray(100){ 0 } }

    repeat(3){ readln().split(" ").forEachIndexed { index, v -> array[it][index] = v.toInt() } }

    var row = 3
    var column = 3
    var count = 0

    while (count != 101) {
        if(array[r - 1][c - 1] == k) { println(count); return }

        //println("row = ${row} column = ${column}")
        if(row < column) {
            var max = 0
            for(i in 0 until column) {
                var pairs = mutableMapOf<Int, Int>()
                for(j in 0 until row) {
                    if(array[j][i] != 0) pairs[array[j][i]] = pairs.getOrDefault(array[j][i], 0) + 1
                }
                var list = pairs.toList().sortedWith(compareBy ({ it.second }, {it.first}))
                for(index in 0 until pairs.size) {
                    if(index * 2 >= 100) break
                    array[index * 2][i] = list[index].first
                    array[index * 2 + 1][i] = list[index].second
                }

                var now = pairs.size  * 2
                while(now < row) {
                    array[now][i] = 0
                    now++
                }

                if(max < pairs.size * 2) max =  pairs.size * 2
            }

            row = max

        } else {
            var max = 0
            for(i in 0 until row) {

                var pairs = mutableMapOf<Int, Int>()
                for(j in 0 until column) {
                    if(array[i][j] != 0) pairs[array[i][j]] = pairs.getOrDefault(array[i][j], 0) + 1
                }

                var list = pairs.toList().sortedWith(compareBy ({ it.second }, {it.first}))
                for(index in 0 until pairs.size) {
                    if(index * 2 >= 100) break
                    array[i][index * 2] = list[index].first
                    array[i][index * 2 + 1] = list[index].second
                }

                var now = pairs.size  * 2
                while(now < column) {
                    array[i][now] = 0
                    now++
                }

                if(max < pairs.size * 2) max =  pairs.size * 2
            }

            column = max
        }

//        repeat(row) {ro ->
//            repeat(column) {co ->
//                print("${array[ro][co]} ")
//            }
//            println()
//        }
//        println("----------------")

        count++
    }

    println(-1)
}