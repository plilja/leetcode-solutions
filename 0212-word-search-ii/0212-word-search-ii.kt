private val DELTAS = listOf(
    Pair(1, 0),
    Pair(0, 1),
    Pair(-1, 0),
    Pair(0, -1)
)

class Solution {
    fun findWords(board: Array<CharArray>, words: Array<String>): List<String> {
        val trie = Trie()
        for (word in words) {
            trie.insert(word)
        }
        val result = HashSet<String>()
        for (y in board.indices) {
            for (x in board[y].indices) {
                visit(Pair(x, y), trie, board, HashSet(), result)
            }
        }
        return result.toList()
    }

    private fun visit(
        point: Pair<Int, Int>,
        trie: Trie,
        board: Array<CharArray>,
        visited: MutableSet<Pair<Int, Int>>,
        result: MutableSet<String>
    ) {
        val childTrie = trie.child(board[point.second][point.first]) ?: return
        visited.add(point)
        childTrie.wordEndsHere?.let { result.add(it) }
        val (x, y) = point
        for ((dx, dy) in DELTAS) {
            val n = Pair(x + dx, y + dy)
            if (n.first < 0 || n.first >= board[0].size) {
                continue
            }
            if (n.second < 0 || n.second >= board.size) {
                continue
            }
            if (n in visited) {
                continue
            }
            visit(n, childTrie, board, visited, result)
        }
        visited.remove(point)
    }
}

class Trie {
    private val children = HashMap<Char, Trie>()
    var wordEndsHere: String? = null

    fun insert(word: String, index: Int = 0) {
        if (word.length == index) {
            wordEndsHere = word
        } else {
            val c = word[index]
            val child = children.computeIfAbsent(c) { Trie() }
            child.insert(word, index + 1)
        }
    }

    fun child(c: Char): Trie? {
        return children[c]
    }
}
