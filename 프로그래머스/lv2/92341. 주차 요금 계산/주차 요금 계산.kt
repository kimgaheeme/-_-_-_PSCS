import kotlin.math.*
class Solution {
    fun solution(fees: IntArray, records: Array<String>): List<Int> {
        var answer: IntArray = intArrayOf()
        
        var record = mutableMapOf<String, MutableList<String>>()
        
        //records split
        records.forEach {
            var l = it.split(" ")
            if(record.containsKey(l[1])) record[l[1]]!!.add(l[0])
            else record[l[1]] = mutableListOf(l[0])           
        }
        
        //시간 계산하기
        var time = record.map {
            var sum: Int = 0
            if(it.value.size % 2 == 1) it.value.add("23:59")
            repeat(it.value.size / 2) { idx ->
                sum += getTimeGap(it.value.get(idx * 2), it.value.get(idx * 2 + 1))
            }
            it.key to sum
        }.toMap()
        
        //요금 계산하기
        var money = time.map {
            it.key to getPrice(it.value, fees)
        }.toMap()

        return money.toList().sortedBy{it.first}.toMap().values.toList()
    }
}

data class CarRecord (
    var time: String,
    var carNum: String,
    var isIn: Boolean = false   
)

fun getTimeGap(n1: String, n2: String): Int {
    var s1 = n1.split(":")
    var s2 = n2.split(":")
    
    return (s2[0].toInt() - s1[0].toInt()) * 60 + (s2[1].toInt() - s1[1].toInt())
}

fun getPrice(time: Int, fees: IntArray): Int {
    var sum = fees[1]
    if(time > fees[0]) {
        sum += (ceil((time.toDouble() - fees[0])/fees[2]) * fees[3]).toInt()
    }
    return sum
}