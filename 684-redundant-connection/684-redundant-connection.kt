class Solution {
    fun findRedundantConnection(edges: Array<IntArray>): IntArray {
        val groups = HashMap<Int, MutableSet<Int>>()
        var result : IntArray? = null
        for (edge in edges) {
            val a = edge[0]
            val b = edge[1]
            if (a !in groups && b !in groups) {
                val group = HashSet<Int>()
                group.add(a)
                group.add(b)
                groups[a] = group
                groups[b] = group
            } else if (a in groups && b !in groups) {
                val group = groups[a]!!
                group.add(b)
                groups[b] = group
            } else if (b in groups && a !in groups) {
                val group = groups[b]!!
                group.add(a)
                groups[a] = group
            } else {
                val group1 = groups[a]!!
                val group2 = groups[b]!!
                if (group1 === group2) {
                    result = edge
                } else {
                    group1.addAll(group2)
                    for (n in group2) {
                        groups[n] = group1
                    }
                }
            }
        }
        return result!!
    }
}