package ru.yotfr.temps.ui.forecast

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import ru.yotfr.temps.domain.model.Units
import ru.yotfr.temps.ui.theme.TempsTheme
import ru.yotfr.temps.ui.utils.animationRes
import ru.yotfr.temps.ui.utils.degrees
import ru.yotfr.temps.ui.utils.humidity
import ru.yotfr.temps.ui.utils.pressure
import ru.yotfr.temps.ui.utils.visibility

@Composable
fun ForecastContent(
    fullForecast: FullForecast
) {
    // TODO: IS DAY
    val currentWeatherComposition by rememberLottieComposition(
        LottieCompositionSpec.RawRes(
            fullForecast.currentWeather.weatherTypeModel.weatherType.animationRes(
                isDay = false
            )
        )
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(32.dp))
        LottieAnimation(
            composition = currentWeatherComposition,
            modifier = Modifier.size(96.dp),
            iterations = LottieConstants.IterateForever
        )
        // TODO: UNITS
        Text(
            text = fullForecast.currentWeather.temperature.temperature.degrees(
                Units.METRIC,
                true
            ),
            style = TempsTheme.typography.displayBold
        )
        Text(
            text = fullForecast.currentWeather.weatherTypeModel.weatherDescription,
            style = TempsTheme.typography.smallHeadline
        )
        Spacer(modifier = Modifier.height(32.dp))
        DailyForecast(dailyForecast = fullForecast.dailyForecast)
        Spacer(modifier = Modifier.height(16.dp))
        // TODO: UNITS
        BriefDetails(
            temperature = fullForecast.currentWeather.temperature.apparent.degrees(
                units = Units.METRIC
            ),
            pressure = fullForecast.currentWeather.pressure.pressure(),
            humidity = fullForecast.currentWeather.humidityPercent.humidity(),
            visibility = fullForecast.currentWeather.visibilityDistance.visibility(
                units = Units.METRIC
            )
        )
    }
}

