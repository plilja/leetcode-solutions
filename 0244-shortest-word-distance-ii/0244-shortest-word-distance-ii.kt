import kotlin.math.abs

class WordDistance(words: Array<String>) {
    private val wordToIndices = HashMap<String, MutableList<Int>>()

    init {
        for ((i, word) in words.withIndex()) {
            wordToIndices.computeIfAbsent(word) { ArrayList() }.add(i)
        }
    }

    fun shortest(word1: String, word2: String): Int {
        if (word1 == word2) {
            return 0
        }
        val indices1 = wordToIndices[word1]!!
        val indices2 = wordToIndices[word2]!!
        var pointer1 = 0
        var pointer2 = 0
        var result = Int.MAX_VALUE
        while (pointer1 < indices1.size && pointer2 < indices2.size) {
            val i = indices1[pointer1]
            val j = indices2[pointer2] 
            val dist = abs(i - j)
            result = minOf(result, dist)
            if (i < j) {
                pointer1++
            } else {
                pointer2++
            }
        }
        return result
    }
}
