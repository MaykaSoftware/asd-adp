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

    fun clearAll(){
        linkedList.clearAll()
    }

    fun peek(): T? {
        if (isEmpty()) {
            return null
        }
        return linkedList.last
    }

    fun search(element: T): Int {
        for (i in linkedList.size downTo 1) {
            if (element == linkedList[i - 1]) {
                return linkedList.size - i + 1
            }
        }
        return -1
    }

    fun get(index: Int): T? {
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

    fun addAll(elements: Iterable<T>) {
        linkedList.addAll(elements)
    }

    fun toList(): LinkedList<T> {
        val linkedListCopy = LinkedList<T>()
        linkedListCopy.addAll(linkedList)
        return linkedListCopy
    }
}

fun <T> linkedListToStack(list: List<T>): StackLinkedList<T> {
    val stack = StackLinkedList<T>()
    stack.addAll(list)
    return stack
}

class StackDynamicArray<T> {
    private val dynamicArray = DynamicArray<T>()

    fun push(element: T) {
        dynamicArray.add(element)
    }

    fun addAll(elements: Iterable<T>) {
        dynamicArray.addAll(elements)
    }

    fun toDynamicArray(): DynamicArray<T> {
        val dynamicArrayCopy = DynamicArray<T>()
        dynamicArrayCopy.addAll(dynamicArray)
        return dynamicArrayCopy
    }

    fun pop(): T? {
        if (isEmpty()) {
            return null
        }
        val poppedElement = dynamicArray[dynamicArray.size - 1]
        dynamicArray.remove(dynamicArray.size - 1)
        return poppedElement
    }

    fun clearAll(){
        dynamicArray.clearAll()
    }
    fun peek(): T? {
        if (isEmpty()) {
            return null
        }
        return dynamicArray[dynamicArray.size - 1]
    }

    fun search(element: T): Int {
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

fun <T> dynamicArrayToStack(list: List<T>): StackDynamicArray<T> {
    val stack = StackDynamicArray<T>()
    stack.addAll(list)
    return stack
}

