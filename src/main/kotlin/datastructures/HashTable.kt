package datastructures

class HashTable<T> {
    private data class KeyValuePair<T>(val key: String, var value: T?)

    private var size = 0
    private var capacity = 10
    private val loadFactor = 0.5
    private val table = MutableList<MutableList<KeyValuePair<T>>>(capacity) { mutableListOf() }

    private fun hash(key: String): Int {
        return key.length % capacity
    }

    private fun quadraticProbe(index: Int, attempt: Int): Int {
        return (index + attempt * attempt) % capacity
    }

    private fun resize() {
        val newCapacity = capacity * 2
        val newTable = MutableList(newCapacity) { mutableListOf<KeyValuePair<T>>() }

        for (list in table) {
            for (pair in list) {
                val newIndex = hash(pair.key)
                newTable[newIndex].add(pair)
            }
        }

        table.clear()
        table.addAll(newTable)
        capacity = newCapacity
    }

    fun insert(key: String, value: T) {
        if (size + 1 > capacity * loadFactor) {
            resize()
        }

        var attempt = 0
        var index = hash(key)

        while (table[index].isNotEmpty()) {
            attempt++
            index = quadraticProbe(index, attempt)
        }

        table[index].add(KeyValuePair(key, value))
        size++
    }

    fun get(key: String): T? {
        var attempt = 0
        var index = hash(key)

        while (table[index].isNotEmpty()) {
            for (pair in table[index]) {
                if (pair.key == key) {
                    return pair.value
                }
            }

            attempt++
            index = quadraticProbe(index, attempt)
        }

        return null
    }

    fun delete(key: String) {
        var attempt = 0
        var index = hash(key)

        while (table[index].isNotEmpty()) {
            val iterator = table[index].iterator()
            while (iterator.hasNext()) {
                if (iterator.next().key == key) {
                    iterator.remove()
                    size--
                    return
                }
            }

            attempt++
            index = quadraticProbe(index, attempt)
        }
    }

    fun update(key: String, newValue: T) {
        var attempt = 0
        var index = hash(key)

        while (table[index].isNotEmpty()) {
            for (pair in table[index]) {
                if (pair.key == key) {
                    pair.value = newValue
                    return
                }
            }

            attempt++
            index = quadraticProbe(index, attempt)
        }
    }
}
