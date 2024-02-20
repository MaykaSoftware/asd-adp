package model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Sorteren(
    @SerialName("lijst_aflopend_2") val lijstAflopend2: List<Int>,
    @SerialName("lijst_float_8001") val lijstFloat8001: List<Double>,
    @SerialName("lijst_gesorteerd_aflopend_3") val lijstGesorteerdAflopend3: List<Int>,
    @SerialName("lijst_gesorteerd_oplopend_3") val lijstGesorteerdOplopend3: List<Int>,
    @SerialName("lijst_herhaald_1000") val lijstHerhaald1000: List<Int>,
    @SerialName("lijst_leeg_0") val lijstLeeg0: List<Int>,
    @SerialName("lijst_null_1") val lijstNull1: List<Int?>,
    @SerialName("lijst_null_3") val lijstNull3: List<Int>,
    @SerialName("lijst_onsorteerbaar_3") val lijstOnsorteerbaar3: List<Double>,
    @SerialName("lijst_oplopend_10000") val lijstOplopend10000: List<Int>,
    @SerialName("lijst_oplopend_2") val lijstOplopend2: List<Int>,
    @SerialName("lijst_willekeurig_10000") val lijstWillekeurig10000: List<Int>,
    @SerialName("lijst_willekeurig_3") val lijstWillekeurig3: List<Int>
)