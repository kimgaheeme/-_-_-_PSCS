import kotlin.math.*

class Solution {
    fun solution(expression: String): Long {
        var answer: Long = 0
        var arr = arrayListOf<String>()
        var temp = ""
        var candidate = listOf("*+-","*-+","+*-","+-*","-+*","-*+")
        
        expression.forEach {
            if(it in listOf('+','-','*')) {
                arr.add(temp)
                temp = ""
                arr.add(it.toString())
            } else {
                temp = temp + it
            }
        }
        arr.add(temp)
        
        candidate.forEach {
            var t: Long = abs(getArr(it, arr, 0))
            if(t > answer) answer = t
        }
        
        
        
        return answer
    }
}

fun getArr(opArr: String, arr: ArrayList<String>, depth: Int): Long {
    if(depth == opArr.length) {
        return arr[0].toLong()
    }else{
        var newArr = arrayListOf<String>()
        var index = 0
        while(index < arr.size) {
            if(arr[index] == opArr[depth].toString()) {
                newArr[newArr.size - 1] = getResult(opArr[depth], newArr[newArr.size - 1].toLong(), arr[index + 1].toLong() ).toString()
                index++
            }
            else {
                newArr.add(arr[index])
            }
            index++
        }
        return getArr(opArr, newArr, depth + 1)
    }
}

fun getResult(op: Char, num1: Long, num2: Long): Long {
    when(op) {
        '+' -> return num1 + num2
        '-' -> return num1 - num2
        else -> return num1 * num2
    }
}