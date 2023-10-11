package ru.yotfr.temps.ui.forecast

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import ru.yotfr.temps.domain.model.on
import ru.yotfr.temps.domain.usecase.GetWeatherUseCase
import javax.inject.Inject

@OptIn(ExperimentalCoroutinesApi::class)
@HiltViewModel
class ForecastViewModel @Inject constructor(
    private val getWeatherUseCase: GetWeatherUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(ForecastState())
    val state = _state.asStateFlow()

    private val refreshTrigger = MutableStateFlow(false)

    init {
        viewModelScope.launch {
            refreshTrigger.flatMapLatest {
                getWeatherUseCase()
            }.collectLatest { dataState ->
                dataState.on(
                    loading = {
                        _state.update {
                            it.copy(
                                isLoading = true
                            )
                        }
                    },
                    success = { placeWithWeatherForecast ->
                        _state.update {
                            it.copy(
                                isLoading = false,
                                placeWithFullForecast = placeWithWeatherForecast
                            )
                        }
                    },
                    error = {
                        _state.update {
                            it.copy(
                                isLoading = false
                            )
                        }
                    }
                )
            }
        }
    }

    fun onEvent(event: ForecastEvent) {
        when (event) {
            ForecastEvent.PullRefresh -> {
                refresh()
            }
        }
    }

    private fun refresh() {
        refreshTrigger.value = !refreshTrigger.value
    }

}