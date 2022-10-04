
class Solution {
    private fun Array<String>.swap(i: Int, j: Int) {
        val temp = this[j]
        this[j] = this[i]
        this[i] = temp
    }

    fun solution(user_id: Array<String>, banned_id: Array<String>): Int {
        val cand = mutableSetOf<MutableSet<String>>()
        fun perm(depth: Int, n: Int, k: Int) {
            if (depth == k) {
                val tempSet = mutableSetOf<String>()
                outer@for (i in banned_id.indices) {
                    if (user_id[i].length != banned_id[i].length) continue
                    for (j in user_id[i].indices) {
                        if (banned_id[i][j] != '*' && user_id[i][j] != banned_id[i][j]) continue@outer
                    }
                    tempSet.add(user_id[i])
                }
                if (tempSet.size == k) cand.add(tempSet)
                return
            } else {
                for (i in depth until n) {
                    user_id.swap(depth, i)
                    perm(depth + 1, n, k)
                    user_id.swap(depth, i)
                }
            }
        }
        perm(0, user_id.size, banned_id.size)
        return cand.size
    }
}
