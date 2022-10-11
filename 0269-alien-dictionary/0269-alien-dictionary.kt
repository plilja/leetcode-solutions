class Solution {
    fun alienOrder(words: Array<String>): String {
        val letters = HashSet<Char>()
        val graph = HashMap<Char, MutableSet<Char>>()
        for ((i, word1) in words.withIndex()) {
            for (c in word1) {
                letters.add(c)
            }
            for (j in i + 1 until words.size) {
                val word2 = words[j]
                if (word1 == word2) {
                    continue
                }
                var diffFound = false
                for (k in 0 until minOf(word1.length, word2.length)) {
                    val c1 = word1[k]
                    val c2 = word2[k]
                    if (c1 != c2) {
                        diffFound = true
                        graph.computeIfAbsent(c2) { HashSet() }.add(c1)
                        break
                    }
                }
                if (!diffFound && word1.length > word2.length) {
                    return ""
                }
            }
        }
        return topologicalSort(letters, graph)
    }

    private fun topologicalSort(nodes: Set<Char>, graph: HashMap<Char, MutableSet<Char>>): String {
        val reverseMap = HashMap<Char, MutableSet<Char>>()
        for ((c1, neighbours) in graph) {
            for (c2 in neighbours) {
                reverseMap.computeIfAbsent(c2) { HashSet() }.add(c1)
            }
        }
        val queue = ArrayDeque<Char>()
        for (c in nodes) {
            if (graph.computeIfAbsent(c) { HashSet() }.isEmpty()) {
                queue.add(c)
            }
        }
        val result = StringBuilder()
        while (queue.isNotEmpty()) {
            val c = queue.removeFirst()
            result.append(c)
            for (n in reverseMap.computeIfAbsent(c) { HashSet() }) {
                graph[n]?.let {
                    it.remove(c)
                    if (it.isEmpty()) {
                        queue.add(n)
                    }
                }
            }
        }
        if (result.length == nodes.size) {
            return result.toString()
        } else {
            return ""
        }
    }
}