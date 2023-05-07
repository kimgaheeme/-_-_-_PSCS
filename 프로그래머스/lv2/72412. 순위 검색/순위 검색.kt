class Solution {
    fun solution(info: Array<String>, query: Array<String>): IntArray {
        val root = Node()

        for (record in info) {
            root.addRecord(record.split(" "))
        }

        root.sortScores()

        val answer = IntArray(query.size)
        for ((index, q) in query.withIndex()) {
            answer[index] = root.count(q.split(" ").filterNot { it == "and" })
            // println("#$index: ${answer[index]}")
        }
        return answer
    }

    class Node {
        var scores: MutableList<Int>? = null
        val children: MutableMap<String, Node> = mutableMapOf()

        fun addRecord(record: List<String>, depth: Int = 0) {
            val key = record[depth]
            if (depth == 4) {
                val score = key.toInt()

                if (scores == null)
                    scores = mutableListOf(score)
                else
                    scores!!.add(score)
            } else {
                if (children[key] == null)
                    children[key] = Node()

                children[key]!!.addRecord(record, depth + 1)
            }
        }

        fun sortScores(depth: Int = 0) {
            if (depth == 4) {
                scores!!.sort()
            } else {
                for (child in children.values)
                    child.sortScores(depth + 1)
            }
        }

        fun count(query: List<String>, depth: Int = 0): Int {
            val key = query[depth]
            if (depth == 4) {
                return scores!!.size - lowerBound(key.toInt())
            } else {
                var sum = 0
                if (key == "-") {
                    for (child in children.values)
                        sum += child.count(query, depth + 1)
                } else {
                    sum += children[key]?.count(query, depth + 1) ?: 0
                }
                return sum
            }
        }

        private fun lowerBound(least: Int): Int {
            if (least > scores!!.last()) return scores!!.size

            var top = scores!!.lastIndex
            var bottom = 0
            var mid = top

            while (top > bottom) {
                val mid = (bottom + top) / 2
                if (mid == top)
                    return top

                if (scores!![mid] < least) {
                    bottom = mid + 1
                } else {
                    top = mid
                }
            }
            return bottom
        }
    }
}