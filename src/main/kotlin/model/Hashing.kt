package model

import kotlinx.serialization.Serializable

@Serializable
data class Hashing(
    val hashtabelsleutelswaardes: Hashtabelsleutelswaardes
)

@Serializable
data class Hashtabelsleutelswaardes(
    val a: List<Int>,
    val b: List<Int>,
    val c: List<Int>,
    val d: List<Int>,
    val e: List<Int>,
    val f: List<Int>,
    val g: List<Int>,
    val h: List<Int>,
    val i: List<Int>,
    val j: List<Int>,
    val k: List<Int>,
    val l: List<Int>,
    val m: List<Int>,
    val n: List<Int>,
    val o: List<Int>,
    val p: List<Int>,
    val q: List<Int>,
    val r: List<Int>,
    val s: List<Int>,
    val t: List<Int>,
    val u: List<Int>,
    val v: List<Int>,
    val w: List<Int>,
    val x: List<Int>,
    val y: List<Int>,
    val z: List<Int>,
    val z0: List<Int>
)