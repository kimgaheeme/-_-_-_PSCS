import kotlin.math.*

class Solution {
    fun solution(n: Int, m: Int, x: Int, y: Int, r: Int, c: Int, k: Int): String {
        var answer: String = ""
        
        //차이 절댓값 더해서 k 보다 크면 impossible && k보다 작은데 뺀값이 홀수일때
        var xlength = r - x
        var ylength = c - y
        val total = abs(xlength) + abs(ylength)
        val dlru = intArrayOf(0,0,0,0)
        
        if(total > k || (total - k)%2 != 0) return "impossible"
        
        
        //필수적으로 필요한 횟수로 배열 만들기 dlru
        if(xlength > 0) dlru[0] = xlength else dlru[3] = abs(xlength)
        if(ylength > 0) dlru[2] = ylength else dlru[1] = abs(ylength)

                
        //k count말고 k - total로 하고 2씩 빼
        var count = k - total
        var now = intArrayOf(x, y)

        while(count != 0) {            
            if(dlru[0] != 0 || now[0] != n) {
                answer += "d"
                now[0] += 1
                if(dlru[0] != 0) dlru[0] -= 1 else { dlru[3] += 1; count -= 2;}
            } else if(dlru[1] != 0 || now[1] != 1) {
                answer += "l"
                now[1] -= 1
                if(dlru[1] != 0) dlru[1] -= 1 else { dlru[2] += 1; count -= 2;}
            } else if(dlru[2] != 0 || now[1] != m) {
                answer += "r"
                now[1] += 1
                if(dlru[2] != 0) dlru[2] -= 1 else { dlru[1] += 1; count -= 2;}
            } else {
                answer += "u"
                now[0] -= 1
                if(dlru[3] != 0) dlru[3] -= 1 else { dlru[0] += 1; count -= 2;}
            }
        }
        
        answer += "d".repeat(dlru[0])
        answer += "l".repeat(dlru[1])
        answer += "r".repeat(dlru[2])
        answer += "u".repeat(dlru[3])
        
        
        return answer
    }
}