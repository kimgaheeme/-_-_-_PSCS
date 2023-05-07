class Solution {
    
    var candidate = ArrayList<IntArray>()
    
    fun solution(users: Array<IntArray>, emoticons: IntArray): IntArray {
        
        var pmax = 0
        var mmax = 0
        
        //candidate
        getArray(emoticons.size - 1, intArrayOf())
        
        candidate.forEach{
            var result = getResult(it, emoticons, users)
            if(pmax < result[0]) {
                pmax = result[0]
                mmax = result[1]
            } else if(pmax == result [0] && mmax < result[1]) {
                mmax = result[1]
            }
        }
        
        var answer: IntArray = intArrayOf(pmax, mmax)
        return answer
    }
    
    fun getArray(depth: Int, array: IntArray) {
        repeat(4){
            if(depth == -1) {
                candidate.add(array)
                return 
            }
            else getArray(depth - 1, array.plus(it))
        }
        return 
    }
    
    fun getResult(array: IntArray, emoticons: IntArray, users: Array<IntArray>): IntArray{
        var discount = intArrayOf(10, 20, 30, 40)
        var people = 0
        var totalCost = 0
        

        var emoticon = emoticons.mapIndexed{ idx, it ->
            emoticons[idx] * (100 - discount[array[idx]]) / 100
        }
        
        
        users.forEach{ user ->
            var cost = 0
            emoticon.forEachIndexed{ idx, it ->
                if(user[0] <= discount[array[idx]]){
                    cost += it
                }
            }
            if(cost >= user[1]) people++
            else totalCost += cost
        }

        return intArrayOf(people, totalCost)
    }
}