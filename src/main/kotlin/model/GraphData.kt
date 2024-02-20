package model

import kotlinx.serialization.Serializable

@Serializable
data class GraphData(
    val lijnlijst: List<List<Int>>,
    val lijnlijst_gewogen: List<List<Int>>,
    val verbindingslijst: List<List<Int>>,
    val verbindingslijst_gewogen: List<List<List<Int>>>,
    val verbindingsmatrix: List<List<Int>>,
    val verbindingsmatrix_gewogen: List<List<Int>>
)

fun GraphData.toMap(): Map<String, Any> {
    return mapOf(
        "lijnlijst" to lijnlijst,
        "lijnlijst_gewogen" to lijnlijst_gewogen,
        "verbindingslijst" to verbindingslijst,
        "verbindingslijst_gewogen" to verbindingslijst_gewogen,
        "verbindingsmatrix" to verbindingsmatrix,
        "verbindingsmatrix_gewogen" to verbindingsmatrix_gewogen
    )
}
