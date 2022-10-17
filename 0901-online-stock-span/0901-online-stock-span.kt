class StockSpanner() {
    private var stack = ArrayDeque<Pair<Int, Int>>()
    private var nextDay = 0

    fun next(price: Int): Int {
        var daysBack = nextDay
        nextDay++
        while (!stack.isEmpty() && stack.last().first <= price) {
            daysBack = stack.removeLast().second
        }
        stack.addLast(Pair(price, daysBack))
        return nextDay - daysBack
    }
}
