package ru.yotfr.temps.data.mapper

import ru.yotfr.temps.data.datasource.local.entity.embedded.ConditionEmbedded
import ru.yotfr.temps.data.datasource.remote.model.ConditionResponseObject
import ru.yotfr.temps.domain.model.Condition
import ru.yotfr.temps.domain.model.ConditionType

fun Int.toConditionType(): ConditionType {
    return ConditionType.values().find { it.code == this }
        ?: throw IllegalArgumentException("Wrong condition code")
}

fun ConditionResponseObject.mapToCondition(): Condition {
    return Condition(
        type = code.toConditionType(),
        description = text
    )
}

fun ConditionResponseObject.mapToConditionEmbedded(): ConditionEmbedded {
    return ConditionEmbedded(
        text = text,
        code = code
    )
}

fun ConditionEmbedded.mapToCondition(): Condition {
    return Condition(
        type = code.toConditionType(),
        description = text
    )
}