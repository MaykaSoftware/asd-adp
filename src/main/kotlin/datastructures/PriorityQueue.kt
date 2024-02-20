package datastructures

class PriorityQueue<T : Comparable<T>> {
    val heap = DynamicArray<T>()

    fun add(element: T) {
        heap.add(element)
        heapifyUp()
    }

    fun addAll(elements: Iterable<T>): DynamicArray<T> {
        for (element in elements) {
            add(element)
        }
        return heap
    }

    fun peek(): T {
        return heap.first()
    }

    fun poll(): T? {
        if (heap.isEmpty()) {
            return null
        }

        val root = heap[0]
        val lastElement = heap.removeAt(heap.size - 1)

        if (!heap.isEmpty()) {
            if (lastElement != null) {
                heap[0] = lastElement
            }
            heapifyDown()
        }

        return root
    }

    private fun heapifyUp() {
        var index = heap.size - 1

        while (index > 0) {
            val parentIndex = (index - 1) / 2

            if (heap[index] >= heap[parentIndex]) {
                break
            }

            heap.swap(index, parentIndex)
            index = parentIndex
        }
    }

    private fun heapifyDown() {
        var index = 0

        while (true) {
            val leftChildIndex = 2 * index + 1
            val rightChildIndex = 2 * index + 2

            var smallest = index

            if (leftChildIndex < heap.size && heap[leftChildIndex] < heap[smallest]) {
                smallest = leftChildIndex
            }

            if (rightChildIndex < heap.size && heap[rightChildIndex] < heap[smallest]) {
                smallest = rightChildIndex
            }

            if (smallest == index) {
                break
            }

            heap.swap(index, smallest)
            index = smallest
        }
    }
}
