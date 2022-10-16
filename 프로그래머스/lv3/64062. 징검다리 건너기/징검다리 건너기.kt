class Solution {
    fun solution(stones: IntArray, k: Int): Int {
        
        var Des = 0
        var Ase = 0
        var j = 1
        while (j < stones.size) {
            if(stones[j] < stones[j - 1]) Des++
            else Ase++
            j++
        }
        
        var stone = stones.toList()
        if(Des > Ase) {stone = stone.asReversed()}
        
        
        
        
        var nowMaxNum = 0
        var answer = 0
        var count = 0
        
        repeat(k) {
            if(stone[it] > nowMaxNum) {nowMaxNum = stone[it]; count = 1}
            else if(stone[it] == nowMaxNum) {count++}
        }
        
        answer = nowMaxNum
        
        var i = k
        while(i < stone.size) {
            if(stone[i] > nowMaxNum) {nowMaxNum = stone[i]; count = 1}
            else if(stone[i] == nowMaxNum) {count++}
            
            if(stone[i - k] == nowMaxNum) {count--}
            if(count == 0) {
                nowMaxNum = stone.subList(i - k + 1,i + 1).maxOrNull()!!
                count = 1
                if(nowMaxNum < answer) answer = nowMaxNum
            }
            i++
        }
        
        return answer
    }
}