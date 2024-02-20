package datastructures

class DynamicArray<T> : Iterable<T> {
    private var array: Array<Any?> = arrayOfNulls(10)
    var size: Int = 0
        private set
        get() = calculateSize()

    fun addAll(elements: Iterable<T>) {
        for (element in elements) {
            add(element)
        }
    }

    fun <T> listToDynamicArray(list: List<T>): DynamicArray<T> {
        val dynamicArray = DynamicArray<T>()
        dynamicArray.addAll(list)
        return dynamicArray
    }

    fun add(element: T) {
        if (size == array.size) {
            resizeArray()
        }
        array[size++] = element
    }

    operator fun set(index: Int, element: T) {
        if (index < 0 || index > size) {
            throw IndexOutOfBoundsException("Index: $index, Size: $size")
        }

        if (size == array.size) {
            resizeArray()
        }

        for (i in size downTo index + 1) {
            array[i] = array[i - 1]
        }

        array[index] = element
        size++
    }

    fun remove(index: Int) {
        if (index < 0 || index >= size) {
            throw IndexOutOfBoundsException("Index: $index, Size: $size")
        }

        for (i in index until size - 1) {
            array[i] = array[i + 1]
        }

        array[size - 1] = null
        size--

        if (size > 0 && size == array.size / 2) {
            resizeArray()
        }
    }

    fun removeAt(index: Int): T? {
        if (index < 0 || index >= size) {
            throw IndexOutOfBoundsException("Index: $index, Size: $size")
        }

        val removedElement = array[index]

        for (i in index until size - 1) {
            array[i] = array[i + 1]
        }

        array[size - 1] = null
        size--

        if (size > 0 && size == array.size / 2) {
            resizeArray()
        }

        return removedElement as? T
    }


    fun removeElement(element: T): Boolean {
        val index = indexOf(element)
        if (index != -1) {
            remove(index)
            return true
        }
        return false
    }

    fun removeBadPerformance(index: Int) {
        for (i in 0 until size) {
            if (array[i] === array[index]) {
                for (j in 0 until size - i - 1) {
                    array[i + j] = array[i + j + 1]
                }
                array[size - 1] = null
                size--
                if (size <= (array.size / 3)) {
                    resizeArray()
                }
                break
            }
        }
    }

    fun clearAll() {
        array = arrayOfNulls(10)
        size = 0
    }

    @Suppress("UNCHECKED_CAST")
    operator fun get(index: Int): T {
        if (index < 0 || index >= size) {
            throw IndexOutOfBoundsException("Index: $index, Size: $size")
        }
        return array[index] as T
    }

    fun find(value: T): Int {
        for (i in 0..<size) {
            if (array[i] == value) {
                return i
            }
        }
        return -1
    }

    fun contains(element: T): Boolean {
        for (i in 0 until size) {
            if (array[i] == element) {
                return true
            }
        }
        return false
    }

    private fun resizeArray() {
        val newArray = arrayOfNulls<Any>(if (size == 0) 10 else size * 2)
        array.copyInto(newArray)
        array = newArray
    }

    fun isEmpty(): Boolean {
        return size == 0
    }

    fun swap(index1: Int, index2: Int) {
        if (index1 < 0 || index1 >= size || index2 < 0 || index2 >= size) {
            throw IndexOutOfBoundsException("Invalid indices: $index1, $index2, Size: $size")
        }

        val temp = array[index1]
        array[index1] = array[index2]
        array[index2] = temp
    }

    private fun calculateSize(): Int {
        var count = 0
        for (element in array) {
            if (element != null) {
                count++
            }
        }
        return count
    }

    fun print() {
        print("[")
        for (i in 0..<size) {
            print(array[i])
            if (i < size - 1) {
                print(", ")
            }
        }
        println("]")
    }

    fun printCapacity() {
        print("[")
        for (i in array.indices) {
            print(array[i])
            if (i < array.size - 1) {
                print(", ")
            }
        }
        println("]")
    }

    override fun iterator(): Iterator<T> {
        return object : Iterator<T> {
            private var currentIndex = 0

            override fun hasNext(): Boolean {
                return currentIndex < size
            }

            override fun next(): T {
                if (!hasNext()) {
                    throw NoSuchElementException()
                }

                return get(currentIndex++)
            }
        }
    }
}