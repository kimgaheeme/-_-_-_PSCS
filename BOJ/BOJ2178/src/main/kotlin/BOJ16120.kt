import java.util.*

fun main() {
    var s = readLine()!!

    var p = 0

    s.forEachIndexed { index, it ->
        if(it == 'P') p++
        else {
            if(p >= 2 && index + 1 < s.length && s[index + 1] == 'P') {
                p -= 2
            }else {
                println("NP")
                return
            }
        }
    }
    if(p == 1) println("PPAP")
    else println("NP")
}