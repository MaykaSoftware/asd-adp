package model

data class Pizza(val name: String, val size: String) : Comparable<Pizza> {
    override fun compareTo(other: Pizza): Int {
        // Compare based on pizza name
        return this.name.compareTo(other.name)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Pizza

        if (name != other.name) return false
        if (size != other.size) return false

        return true
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + size.hashCode()
        return result
    }
}