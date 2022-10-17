class LFUCache(private val capacity: Int) {
    private val keyToVal = HashMap<Int, Int>()
    private val keyToFreq = HashMap<Int, Int>()
    private val freqToKeys = HashMap<Int, LinkedHashSet<Int>>()
    private var leastFreq = Int.MAX_VALUE

    fun get(key: Int): Int {
        if (capacity == 0) {
            return -1
        }
        touchKey(key)
        return keyToVal[key] ?: -1
    }

    fun put(key: Int, value: Int) {
        if (capacity == 0) {
            return
        }
        if (key in keyToVal) {
            touchKey(key)
            keyToVal[key] = value
        } else {
            if (keyToVal.size == capacity) {
                // find the one with least freq and evict it
                val itemsWithLeastFreq = freqToKeys[leastFreq]!!
                val remove = itemsWithLeastFreq.iterator().next()
                itemsWithLeastFreq.remove(remove)
                if (itemsWithLeastFreq.isEmpty()) {
                    freqToKeys.remove(leastFreq)
                }
                keyToFreq.remove(remove)
                keyToVal.remove(remove)
            }
            keyToVal[key] = value
            keyToFreq[key] = 1
            freqToKeys.computeIfAbsent(1, {k -> LinkedHashSet<Int>()}).add(key)
            leastFreq = 1
        }
    }

    fun touchKey(key: Int) {
        if (key in keyToFreq) {
            val newFreq = keyToFreq.merge(key, 1) { a, b -> a + b }!!
            val oldFreq = newFreq - 1
            val oldFreqKeys = freqToKeys[oldFreq]!!
            oldFreqKeys.remove(key)
            if (oldFreqKeys.isEmpty()) {
                freqToKeys.remove(oldFreq)
                if (oldFreq == leastFreq) {
                    leastFreq = newFreq
                }
            }
            freqToKeys.computeIfAbsent(newFreq, { k -> LinkedHashSet<Int>() }).add(key)
        }
    }

}

/**
 * Your LFUCache object will be instantiated and called as such:
 * var obj = LFUCache(capacity)
 * var param_1 = obj.get(key)
 * obj.put(key,value)
 */