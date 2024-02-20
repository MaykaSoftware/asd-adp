package datastructures

class Node<T>(var data: T, var next: Node<T>? = null)

class LinkedList<T> : Iterable<T> {
    private var head: Node<T>? = null
    private var tail: Node<T>? = null

    fun addFirst(element: T) {
        val newNode = Node(element)
        if (head == null) {
            head = newNode
            tail = newNode
        } else {
            newNode.next = head
            head = newNode
        }
        size++
    }

    fun addLast(element: T) {
        val newNode = Node(element)
        if (head == null) {
            head = newNode
            tail = newNode
        } else {
            tail?.next = newNode
            tail = newNode
        }
    }

    fun addAll(elements: Iterable<T>) {
        for (element in elements) {
            addLast(element)
        }
    }

    fun <T> listToLinkedList(list: List<T>): LinkedList<T> {
        val linkedList = LinkedList<T>()
        linkedList.addAll(list)
        return linkedList
    }

    fun insert(index: Int, element: T) {
        if (index < 0) {
            throw IndexOutOfBoundsException("Index: $index")
        }

        val newNode = Node(element)
        if (index == 0) {
            newNode.next = head
            head = newNode
        } else {
            var current = head
            var currentIndex = 0

            while (current != null && currentIndex < index - 1) {
                current = current.next
                currentIndex++
            }

            if (current == null) {
                throw IndexOutOfBoundsException("Index: $index, Size: $currentIndex")
            }

            newNode.next = current.next
            current.next = newNode
        }
    }

    fun removeByValue(value: T) {
        var current = head
        var prev: Node<T>? = null

        while (current != null) {
            if (current.data == value) {
                if (prev == null) {
                    // Removing the first element
                    head = current.next
                } else {
                    // Removing an element in the middle or at the end
                    prev.next = current.next
                    if (current.next == null) {
                        // Update tail if the last element is removed
                        tail = prev
                    }
                }
                size--
                return
            }

            prev = current
            current = current.next
        }
    }

    fun removeFirst(): T? {
        if (head == null) {
            return null
        }

        val removedData = head!!.data
        head = head!!.next

        if (head == null) {
            tail = null
        }

        return removedData
    }

    fun removeLast(): T? {
        if (head == null) {
            return null
        }

        val removedData: T
        if (head == tail) {
            removedData = head!!.data
            head = null
            tail = null
        } else {
            var current = head
            while (current?.next != tail) {
                current = current?.next
            }
            removedData = tail!!.data
            tail = current
            tail?.next = null
        }

        return removedData
    }

    fun remove(index: Int) {
        if (index < 0) {
            throw IndexOutOfBoundsException("Index: $index")
        }

        if (index == 0) {
            head = head?.next
        } else {
            var current = head
            var currentIndex = 0

            while (current != null && currentIndex < index - 1) {
                current = current.next
                currentIndex++
            }

            if (current?.next == null) {
                throw IndexOutOfBoundsException("Index: $index, Size: $currentIndex")
            }

            current.next = current.next?.next
        }
    }

    fun clearAll() {
        head = null
        size = 0
    }

    operator fun get(index: Int): T? {
        if (index < 0) {
            throw IndexOutOfBoundsException("Index: $index")
        }

        var current = head
        var currentIndex = 0

        while (current != null && currentIndex < index) {
            current = current.next
            currentIndex++
        }

        return current?.data
    }

    val first: T?
        get() = head?.data

    val last: T?
        get() = tail?.data

    var size: Int = 0
        private set
        get() {
            var count = 0
            var current = head
            while (current != null) {
                count++
                current = current.next
            }
            return count
        }

    fun isEmpty(): Boolean {
        return head == null
    }

    fun isNotEmpty(): Boolean {
        return head != null
    }

    fun printList() {
        var current = head
        while (current != null) {
            print("${current.data} -> ")
            current = current.next
        }
        println("null")
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

                return get(currentIndex++)!!
            }
        }
    }
}