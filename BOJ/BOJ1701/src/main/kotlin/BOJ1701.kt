fun main() {
    var input = readLine()!!

    var answer = 0

    for (i in 0 until input.length) {
        var pi = getPi(input.substring(i, input.length))
        if(pi > answer) answer = pi
        if(answer > input.length - 0) break
    }

    println(answer)
    return
}

fun getPi(sub: String): Int {
    var j = 0
    var pi = IntArray(sub.length) { 0 }

    for( i in 1 until sub.length) {
        while(j > 0 && sub[j] != sub[i]) j = pi[j-1].toInt()
        if(sub[i] == sub[j]) pi[i] = ++j
    }

    return pi.max()
}