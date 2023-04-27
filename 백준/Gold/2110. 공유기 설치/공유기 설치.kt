
var homeList = mutableListOf<Long>()

fun main() {
    var input = readLine()!!.split(" ").map{ it.toInt() }
    var C = input[1]
    var N = input[0]

    repeat(N) { homeList.add(readLine()!!.toLong()) }
    homeList.sort()

    var start = 1L
    var end = homeList.last() - homeList.first()
    var mid = (start + end) / 2

    while(start <= end) {
        if(isPossible(mid, C))  {
            if(!isPossible(mid + 1L, C)) {println(mid); return}
            start = mid + 1
        } else { end = mid - 1 }
        mid = (start + end) / 2
    }
}

fun isPossible(min: Long, C: Int): Boolean {
    var now = homeList.first() + min
    var count = 1

    for(i in 1 until homeList.size) {
        if(now <= homeList[i]) {
            count++
            now = homeList[i] + min
        }
    }

    return count >= C
}