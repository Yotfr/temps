package ru.yotfr.temps.ui.utils

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import ru.yotfr.temps.R
import ru.yotfr.temps.domain.model.Units

fun Int.degrees(
    units: Units,
    display: Boolean = false
): String {
    val space = if (display) "" else " "
    return this.toString() + space + if (units == Units.METRIC) "\u2103" else "\u2109"
}

@Composable
fun Int.pressure(): String {
    return this.toString() + " " + stringResource(id = R.string.pressureUnits)
}

@Composable
fun Int.visibility(
    units: Units
): String {
    return (this / 1000).toString() + " " + if (units == Units.METRIC) {
        stringResource(id = R.string.kilometers)
    } else stringResource(id = R.string.miles)
}

fun Int.humidity(): String {
    return "$this %"
}
