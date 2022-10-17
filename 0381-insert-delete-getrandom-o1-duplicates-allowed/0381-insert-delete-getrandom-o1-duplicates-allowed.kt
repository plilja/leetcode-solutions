import java.util.Random
import kotlin.math.max

class RandomizedCollection() {
    private val random = Random()
    private val valueToIdentifiers = HashMap<Int, LinkedHashSet<Int>>()
    private val identifierToValue = HashMap<Int, Int>()
    private var maxIdentifier = -1

    fun insert(value: Int): Boolean {
        return addValue( ++maxIdentifier, value)
    }

    fun remove(value: Int): Boolean {
        val identifiers = valueToIdentifiers.get(value) ?: return false
        val identifier = identifiers.iterator().next()
        removeValue(identifier)
        if (identifier < maxIdentifier) {
            val maxIdentifierValue = identifierToValue[maxIdentifier]!!
            removeValue(maxIdentifier)
            addValue(identifier, maxIdentifierValue)
        }
        maxIdentifier--
        return true
    }

    private fun removeValue(identifier: Int) {
        val value = identifierToValue[identifier]
        val identifiers = valueToIdentifiers.get(value)!!
        identifiers.remove(identifier)
        if (identifiers.isEmpty()) {
            valueToIdentifiers.remove(value)
        }
        identifierToValue.remove(identifier)
    }

    private fun addValue(identifier: Int, value: Int): Boolean {
        identifierToValue[identifier] = value
        val identifiers = valueToIdentifiers.computeIfAbsent(value) { LinkedHashSet() }
        val result = identifiers.isEmpty()
        identifiers.add(identifier)
        return result
    }

    fun getRandom(): Int {
        val identifier = random.nextInt(maxIdentifier + 1)
        return identifierToValue[identifier]!!
    }
}
