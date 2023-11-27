package datastructures

class PriorityQueue<T : Comparable<T>> {
    private val heap: MutableList<T> = mutableListOf()

    fun offer(element: T) {
        heap.add(element)
        heapifyUp(heap.size - 1)
    }

    fun poll(): T? {
        if (isEmpty()) {
            return null
        }

        if (heap.size == 1) {
            return heap.removeAt(0)
        }

        val top = heap[0]
        heap[0] = heap.removeAt(heap.size - 1)
        heapifyDown(0)
        return top
    }

    fun peek(): T? {
        return if (isEmpty()) null else heap[0]
    }

    fun isEmpty(): Boolean {
        return heap.isEmpty()
    }

    fun size(): Int {
        return heap.size
    }

    private fun heapifyUp(index: Int) {
        var currentIndex = index
        while (currentIndex > 0) {
            val parentIndex = (currentIndex - 1) / 2
            if (heap[currentIndex] < heap[parentIndex]) {
                swap(currentIndex, parentIndex)
                currentIndex = parentIndex
            } else {
                break
            }
        }
    }

    private fun heapifyDown(index: Int) {
        var currentIndex = index
        while (true) {
            val leftChildIndex = 2 * currentIndex + 1
            val rightChildIndex = 2 * currentIndex + 2
            var smallestIndex = currentIndex

            if (leftChildIndex < heap.size && heap[leftChildIndex] < heap[smallestIndex]) {
                smallestIndex = leftChildIndex
            }

            if (rightChildIndex < heap.size && heap[rightChildIndex] < heap[smallestIndex]) {
                smallestIndex = rightChildIndex
            }

            if (smallestIndex != currentIndex) {
                swap(currentIndex, smallestIndex)
                currentIndex = smallestIndex
            } else {
                break
            }
        }
    }

    private fun swap(index1: Int, index2: Int) {
        val temp = heap[index1]
        heap[index1] = heap[index2]
        heap[index2] = temp
    }
}