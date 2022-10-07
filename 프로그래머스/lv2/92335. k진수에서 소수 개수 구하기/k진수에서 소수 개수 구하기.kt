import kotlin.math.sqrt

class Solution {
    fun solution(n: Int, k: Int): Int {
        
        var answer = 0
        
				//0으로 split하고 그 수가 소수인지 판단한다.
        n.toString(k).split("0").forEach { it ->
            if(it.toLongOrNull() != null) answer += isPrime(it.toLong())
        }
        
        return answer
    }
}

//sqrt(N)까지 반복하여 소수를 찾아낸다.
fun isPrime(n: Long): Int {
    if(n == 1L) return 0
    
    var i = 2
    while(i <= sqrt(n.toDouble())) {
        if(n % i == 0L) return 0
        i++
    }
    return 1
}