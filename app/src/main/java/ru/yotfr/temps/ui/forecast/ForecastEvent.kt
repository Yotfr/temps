package ru.yotfr.temps.ui.forecast

sealed interface ForecastEvent {
    data object PullRefresh : ForecastEvent
}