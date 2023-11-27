package datastructures

class DoublyNode<T>(var data: T, var prev: DoublyNode<T>? = null, var next: DoublyNode<T>? = null)

class DoublyLinkedList<T> : Iterable<T>{
    private var head: DoublyNode<T>? = null
    private var tail: DoublyNode<T>? = null

    fun push(element: T) {
        val newNode = DoublyNode(element)
        if (head == null) {
            head = newNode
            tail = newNode
        } else {
            newNode.next = head
            head?.prev = newNode
            head = newNode
        }
    }

    fun addAll(elements: Iterable<T>) {
        for (element in elements) {
            push(element)
        }
    }

    fun <T> listToDoublyLinkedList(list: List<T>): DoublyLinkedList<T> {
        val doublyLinkedList = DoublyLinkedList<T>()
        doublyLinkedList.addAll(list)
        return doublyLinkedList
    }

    fun append(element: T) {
        val newNode = DoublyNode(element)
        if (head == null) {
            head = newNode
            tail = newNode
        } else {
            tail?.next = newNode
            newNode.prev = tail
            tail = newNode
        }
    }

    fun insert(index: Int, element: T) {
        if (index < 0) {
            throw IndexOutOfBoundsException("Index: $index")
        }

        val newNode = DoublyNode(element)
        if (index == 0) {
            newNode.next = head
            head?.prev = newNode
            head = newNode
            if (tail == null) {
                tail = newNode
            }
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
            newNode.prev = current
            current.next?.prev = newNode
            current.next = newNode

            if (newNode.next == null) {
                tail = newNode
            }
        }
    }

    fun pop(): T? {
        if (head == null) {
            return null
        }

        val removedData = head!!.data
        head = head!!.next

        if (head != null) {
            head!!.prev = null
        } else {
            tail = null
        }

        return removedData
    }

    fun removeLast(): T? {
        if (tail == null) {
            return null
        }

        val removedData = tail!!.data
        tail = tail!!.prev

        if (tail != null) {
            tail!!.next = null
        } else {
            head = null
        }

        return removedData
    }

    fun remove(index: Int) {
        if (index < 0) {
            throw IndexOutOfBoundsException("Index: $index")
        }

        if (index == 0) {
            head = head?.next
            head?.prev = null
            if (head == null) {
                tail = null
            }
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

            val nodeToRemove = current.next
            current.next = nodeToRemove?.next
            nodeToRemove?.next?.prev = current

            if (nodeToRemove == tail) {
                tail = current
            }
        }
    }

    fun clearAll() {
        head = null
        tail = null
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


    fun printList() {
        var current = head
        while (current != null) {
            print("${current.data} <-> ")
            current = current.next
        }
        println("null")
    }

    override fun iterator(): Iterator<T> {
        return object : Iterator<T> {
            private var current: DoublyNode<T>? = head

            override fun hasNext(): Boolean {
                return current != null
            }

            override fun next(): T {
                if (!hasNext()) {
                    throw NoSuchElementException()
                }

                val data = current!!.data
                current = current!!.next
                return data
            }
        }
    }
}