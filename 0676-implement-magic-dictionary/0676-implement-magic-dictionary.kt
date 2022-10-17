class MagicDictionary() {
    private var children = HashMap<Char, MagicDictionary>()
    private var wordEndsHere = false

    fun buildDict(dictionary: Array<String>) {
        children.clear()
        for (w in dictionary) {
            insert(w)
        }
    }

    private fun insert(w: String, index: Int = 0) {
        if (w.length == index) {
            wordEndsHere = true
        } else {
            val c = w[index]
            val child = children.computeIfAbsent(c) { MagicDictionary() }
            child.insert(w, index + 1)
        }
    }

    fun search(searchWord: String): Boolean {
        val q = ArrayDeque<Triple<MagicDictionary, Int, Boolean>>()
        q.add(Triple(this, 0, false))
        while (!q.isEmpty()) {
            val (md, index, subUsed) = q.removeFirst()
            if (index == searchWord.length) {
                if (md.wordEndsHere && subUsed) {
                    return true
                } else {
                    continue
                }
            }
            val c = searchWord[index]
            val child = md.children[c]
            if (child != null) {
                q.add(Triple(child, index + 1, subUsed))
            }
            if (!subUsed) {
                for ((key, value) in md.children) {
                    if (key != c) {
                        q.add(Triple(value, index + 1, true))
                    }
                }
            }
        }
        return false
    }
}