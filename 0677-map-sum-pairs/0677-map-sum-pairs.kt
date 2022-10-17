/**
 * Your MapSum object will be instantiated and called as such:
 * var obj = MapSum()
 * obj.insert(key,`val`)
 * var param_2 = obj.sum(prefix)
 */
class MapSum() {
    private var children = HashMap<Char, MapSum>()
    private var stored = HashMap<String, Int>()
    private var sum = 0

    fun insert(key: String, value: Int) {
        insertHelper(key, 0, value)
    }

    private fun insertHelper(key: String, index: Int, value: Int) {
        val old = stored.getOrDefault(key, 0)
        sum -= old
        sum += value
        stored[key] = value
        if (index < key.length) {
            val c = key[index]
            val child = children.computeIfAbsent(c, { k -> MapSum() })
            child.insertHelper(key, index + 1, value)
        }
    }

    fun sum(prefix: String): Int {
        return sumHelper(prefix, 0)
    }

    private fun sumHelper(prefix: String, index: Int): Int {
        if (index == prefix.length) {
            return sum
        } else {
            val c = prefix[index]
            val child = children[c]?: return 0
            return child.sumHelper(prefix, index + 1)
        }
    }
}