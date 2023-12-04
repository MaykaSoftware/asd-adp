package datastructures

class Deque<T>: Iterable<T> {
    private val doublyLinkedList: DoublyLinkedList<T> = DoublyLinkedList()

    fun addFirst(element: T) {
        doublyLinkedList.push(element)
    }

    fun addLast(element: T) {
        doublyLinkedList.append(element)
    }

    fun addAll(elements: Iterable<T>) {
        doublyLinkedList.addAll(elements)
    }

    fun removeFirst(): T? {
        if (isEmpty()) {
            return null
        }
        return doublyLinkedList.pop()
    }

    fun removeLast(): T? {
        if (isEmpty()) {
            return null
        }
        return doublyLinkedList.removeLast()
    }

    fun peekFirst(): T? {
        if (isEmpty()) {
            return null
        }
        return doublyLinkedList.first
    }

    fun peekLast(): T? {
        if (isEmpty()) {
            return null
        }
        return doublyLinkedList.last
    }

    fun isEmpty(): Boolean {
        return doublyLinkedList.isEmpty()
    }

    fun size(): Int {
        return doublyLinkedList.size
    }

    override fun iterator(): Iterator<T> {
        return doublyLinkedList.iterator()
    }
}

fun <T> doublyLinkedListToDeque(list: List<T>): Deque<T> {
    val deque = Deque<T>()
    deque.addAll(list)
    return deque
}