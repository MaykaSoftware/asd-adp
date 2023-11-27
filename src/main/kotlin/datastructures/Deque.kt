package datastructures

class Deque<T> {
    private val elements: LinkedList<T> = LinkedList()

    fun addFirst(element: T) {
        elements.addFirst(element)
    }

    fun addLast(element: T) {
        elements.addLast(element)
    }

    fun removeFirst(): T? {
        if (isEmpty()) {
            return null
        }
        return elements.removeFirst()
    }

    fun removeLast(): T? {
        if (isEmpty()) {
            return null
        }
        return elements.removeLast()
    }

    fun peekFirst(): T? {
        if (isEmpty()) {
            return null
        }
        return elements.first
    }

    fun peekLast(): T? {
        if (isEmpty()) {
            return null
        }
        return elements.last
    }

    fun isEmpty(): Boolean {
        return elements.isEmpty()
    }

    fun size(): Int {
        return elements.size
    }
}