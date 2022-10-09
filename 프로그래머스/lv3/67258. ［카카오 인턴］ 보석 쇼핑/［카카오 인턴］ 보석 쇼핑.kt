class Solution {
    fun solution(gems: Array<String>): IntArray {
        val mp = hashMapOf<String, Int>()
        gems.forEach { mp[it] = 0 }
        var first = 0
        var second = 9999999

        val full = mp.size

        var left = 0
        var right = mp.size - 1
        for (i in 0 until mp.size)
            mp[gems[i]] = mp[gems[i]]!! + 1
        var contains = mp.count { it.value != 0 }
        while (right <= gems.size) {
            if (contains == full) {
                if (second - first > right - left) {
                    second = right
                    first = left
                }
                if (mp[gems[left]] == 1) contains--
                mp[gems[left]] = mp[gems[left]]!! - 1
                left++
            } else {
                right++
                if (right < gems.size) {
                    if (mp[gems[right]] == 0) contains++
                    mp[gems[right]] = mp[gems[right]]!! + 1
                }
            }
        }
        return intArrayOf(first + 1, second + 1)
    }
}