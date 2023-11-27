package datastructures

class StackLinkedList<T> {
    private val linkedList = LinkedList<T>()

    fun push(element: T) {
        linkedList.addLast(element)
    }

    fun pop(): T? {
        if (isEmpty()) {
            return null
        }
        return linkedList.removeLast()
    }

    fun peek(): T? {
        if (isEmpty()) {
            return null
        }
        return linkedList.last
    }

    fun search(element: T): Int {
        // Search for the element in the stack and return its 1-based position
        for (i in linkedList.size downTo 1) {
            if (element == linkedList[i - 1]) {
                return linkedList.size - i + 1
            }
        }
        return -1
    }

    fun get(index: Int): T? {
        // Get the element at the specified 1-based position from the top of the stack
        if (index > 0 && index <= linkedList.size) {
            return linkedList[linkedList.size - index]
        }
        return null
    }

    fun isEmpty(): Boolean {
        return linkedList.isEmpty()
    }

    fun size(): Int {
        return linkedList.size
    }
}

class StackDynamicArray<T> {
    private val dynamicArray = DynamicArray<T>()

    fun push(element: T) {
        dynamicArray.add(element)
    }

    fun pop(): T? {
        if (isEmpty()) {
            return null
        }
        val poppedElement = dynamicArray[dynamicArray.size - 1]
        dynamicArray.remove(dynamicArray.size - 1)
        return poppedElement
    }

    fun peek(): T? {
        if (isEmpty()) {
            return null
        }
        return dynamicArray[dynamicArray.size - 1]
    }

    fun search(element: T): Int {
        // Search for the element in the stack and return its 1-based position
        for (i in dynamicArray.size downTo 1) {
            if (element == dynamicArray[i - 1]) {
                return dynamicArray.size - i + 1
            }
        }
        return -1
    }

    fun isEmpty(): Boolean {
        return dynamicArray.isEmpty()
    }

    fun size(): Int {
        return dynamicArray.size
    }
}

