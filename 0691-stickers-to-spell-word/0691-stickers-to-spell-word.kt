private const val BIG = 1000000

class Solution {
    fun minStickers(stickers: Array<String>, target: String): Int {
        val charToStickers = HashMap<Char, MutableList<MutableMap<Char, Int>>>()
        for (sticker in stickers) {
            val stickerCharCount = HashMap<Char, Int>()
            for (c in sticker) {
                stickerCharCount.merge(c, 1) { a, b -> a + b }

            }
            for (c in stickerCharCount.keys) {
                charToStickers.computeIfAbsent(c) { ArrayList() }.add(stickerCharCount)
            }
        }
        val result = solve(charToStickers, target, HashMap())
        return if (result < BIG) {
            result
        } else {
            -1
        }
    }

    private fun solve(
        charToStickers: Map<Char, List<MutableMap<Char, Int>>>,
        target: String,
        cache: MutableMap<String, Int>
    ): Int {
        if (target.isEmpty()) {
            return 0
        } else if (target in cache) {
            return cache[target]!!
        } else {
            var result = BIG
            val first = target[0]
            for (sticker in charToStickers.getOrDefault(first, emptyList())) {
                val remainder = StringBuilder()
                val removed = StringBuilder()
                for (c in target) {
                    val count = sticker.getOrDefault(c, 0)
                    if (count > 0) {
                        sticker[c] = count - 1
                        removed.append(c)
                    } else {
                        remainder.append(c)
                    }
                }
                for (c in removed) {
                    sticker.merge(c, 1) { a, b -> a + b }
                }
                val sub = solve(charToStickers, remainder.toString(), cache) + 1
                result = minOf(sub, result)
            }
            cache[target] = result
            return result
        }
    }
}
