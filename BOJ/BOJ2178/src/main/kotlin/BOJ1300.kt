import kotlin.math.*

fun main() {
    var N = readLine()!!.toLong()
    var k = readLine()!!.toLong()

    var start = 1L
    var end = k
    var mid = 0L

    while (start <= end) {
        mid = (start + end) / 2
        var count = 0L

        for(i in 1 .. N) {
            var c = mid / i
            count += if(c > N) N else c
        }
        if(count < k) start = mid + 1
        else {
            end = mid
        }
        println("${mid}, ${start}, ${end}")
    }


}