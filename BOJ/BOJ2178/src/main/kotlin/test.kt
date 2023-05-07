fun main() {

    var s = "test"
    var count = 0
    while(s != null) {
        s = readln()
        var list = s.split(":")

        if(list.size > 1) println("${count++}. ${list[1]}")
    }
}