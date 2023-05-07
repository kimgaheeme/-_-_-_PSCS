import java.util.*

fun main() {
    var n = readLine()!!.toInt()
    var answerList = mutableListOf<Mountain>()

    var mountainNum = 0
    var count = 2
    var before = 0
    var flag = false

    repeat(n) {
        var link = readLine()!!.split(" ").map { it. toInt() }

        if(it > 0) {
            if(link[1] - before > 0 && link[1] * before <= 0 && link[1] != 0) {
                count--
                answerList.add(Mountain(link[0], mountainNum))
            }
            if(before - link[1] > 0 && link[1] * before <= 0 && before != 0) {
                if(count == 2 && mountainNum == 0) {
                    flag = true
                    count = 0
                    answerList.add(Mountain(link[0], mountainNum))
                }else {
                    count--
                    answerList.add(Mountain(link[0], mountainNum))
                }

            }
            if(count == 0) {
                mountainNum++
                count = 2
            }
        }
        before = link[1]
    }
    if(flag) {
        answerList[answerList.size - 1].num = 0
    }


    answerList.sortBy { it.x }
    println(answerList)
    var include = false
    var notIncluded = 0
    var notInclude = 0
    for(i in 0 until answerList.size - 1) {
        if(answerList[i].num == answerList[i + 1].num) notInclude++
    }

    var stack = Stack<Mountain>()
    answerList.forEach {
        if(stack.isEmpty()) {
            stack.push(it)
            include = true
        }else if(stack.peek().num != it.num){
            stack.push(it)
            include = true
        }else {
            stack.pop()
            if(stack.isEmpty() && include) {
                notIncluded++
                include = false
            }
        }
    }


    println("$notIncluded $notInclude")
}

data class Mountain(
    var x: Int,
    var num: Int,
)