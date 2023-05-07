import kotlin.math.*
class Solution {
    fun solution(numbers: LongArray): ArrayList<Int> {
        var answer = arrayListOf<Int>()
        
        numbers.forEach{
            var num = getString(it)
            //println("num ${num}")
            if(num[num.length/2] == '0') {
                answer.add(0)
            }
            else{
                if(isRight(num.substring(0 until num.length/2)) 
                    && isRight(num.substring(num.length/2 + 1, num.length))) {
                    answer.add(1)
                }
                else {
                    answer.add(0)
                }
            }
        }
        return answer
    }
}

fun isRight(tree: String): Boolean {
    
    //println(tree)
    if(tree.length < 3) return true
    
    if(tree.length == 3){
        if(tree[1] == '1') return true
        else if(tree[0] == '0' && tree[2] == '0') return true
        else return false
        
    }else{
        if(tree[tree.length/2] == '1') {
            return isRight(tree.substring(0 until tree.length/2)) 
                    && isRight(tree.substring(tree.length/2 + 1, tree.length))
        }else {
            if(!isZero(tree.substring(0 until tree.length/2))
               || !isZero(tree.substring(tree.length/2 + 1, tree.length)))  return false
            else return true
        }
    }
}

fun getPow(a: Long, count: Long): Long{
    var result = 1L
    repeat(count.toInt()){
        result *= a
    }
    return result
}


fun getString(num: Long): String{
    var numString = num.toString(2)
    var h = ceil(log(numString.length.toDouble() + 1, 2.0))
    
    repeat((getPow(2L, h.toLong()) - numString.length - 1).toInt()){
        numString = '0' + numString
    }
    return numString
}

fun isZero(string: String): Boolean{
    string.forEach{
        if(it != '0') return false
    }
    return true
}
