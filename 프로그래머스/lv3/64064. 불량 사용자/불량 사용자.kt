class Solution {

   fun solution(userIds: Array<String>, bannedIds: Array<String>): Int {
      val backtrackHashes = mutableSetOf<Int>()
      val matchResults = Array(userIds.size) { BooleanArray(bannedIds.size) }

      fun backtrack(level: Int, success: Int, visitFlag: Int): Int {
         if (level >= bannedIds.size) {
            return if (success == bannedIds.size && visitFlag !in backtrackHashes) {
               backtrackHashes += visitFlag
               1
            } else {
               0
            }
         }

         tailrec fun loop(index: Int, acc: Int): Int {
            if (index >= userIds.size) {
               return acc
            }
            val mask = 1 shl index
            val child = if (visitFlag and mask == 0 && matchResults[index][level]) {
               backtrack(level + 1, success + 1, visitFlag or mask)
            } else {
               0
            }
            return loop(index + 1, acc + child)
         }

         return loop(0, 0)
      }

      for ((rowIndex, userId) in userIds.withIndex()) {
         for ((colIndex, bannedId) in bannedIds.withIndex()) {
            matchResults[rowIndex][colIndex] = matches(userId, bannedId)
         }
      }

      return backtrack(0, 0, 0)
   }


   fun matches(userId: String, bannedId: String): Boolean {
      if (userId.length != bannedId.length) {
         return false
      }

      tailrec fun matchesImpl(index: Int): Boolean {
         if (index >= userId.length) {
            return index >= bannedId.length
         }
         if (bannedId[index] != '*' && userId[index] != bannedId[index]) {
            return false
         }
         return matchesImpl(index + 1)
      }

      return matchesImpl(0)
   }
}