package ru.yotfr.temps.ui.forecast

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.KeyboardArrowLeft
import androidx.compose.material.icons.outlined.KeyboardArrowRight
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import ru.yotfr.temps.R
import ru.yotfr.temps.domain.model.Units
import ru.yotfr.temps.ui.theme.TempsTheme
import ru.yotfr.temps.ui.utils.animationRes
import ru.yotfr.temps.ui.utils.degrees
import java.time.format.DateTimeFormatter

@Composable
fun DailyForecast(
    dailyForecast: List<DailyWeather>
) {
    val totalPages by remember { mutableIntStateOf(dailyForecast.size) }
    var currentPage by remember { mutableIntStateOf(0) }

    Surface(
        modifier = Modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        border = BorderStroke(1.dp, SolidColor(Color.Black)),
        color = Color.Transparent
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            HourlyForecastHeader(
                date = dailyForecast[currentPage].date.format(DateTimeFormatter.ofPattern("MMMM, d")),
                previousPage = {
                    if (currentPage > 0) {
                        currentPage -= 1
                    }
                },
                nextPage = {
                    if (currentPage < totalPages - 1) {
                        currentPage += 1
                    }
                },
                isPreviousButtonEnabled = currentPage > 0,
                isNextButtonEnabled = currentPage < totalPages - 1
            )
            HourlyForecast(
                hourlyForecast = dailyForecast[currentPage].hourlyForecast
            )
        }
    }
}

@Composable
fun HourlyForecastHeader(
    date: String,
    previousPage: () -> Unit,
    nextPage: () -> Unit,
    isPreviousButtonEnabled: Boolean,
    isNextButtonEnabled: Boolean
) {
    Row(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                horizontal = 16.dp,
                vertical = 8.dp
            ),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = stringResource(id = R.string.forecast),
            style = TempsTheme.typography.bodySmallRegular
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Icon(
                imageVector = Icons.Outlined.KeyboardArrowLeft,
                contentDescription = null,
                tint = if (isPreviousButtonEnabled) Color.Black else Color.Black.copy(alpha = 0.3f),
                modifier = Modifier.clickable {
                    if (isPreviousButtonEnabled) {
                        previousPage()
                    }
                }
            )
            Text(
                text = date,
                style = TempsTheme.typography.bodySmallLight
            )
            Icon(
                imageVector = Icons.Outlined.KeyboardArrowRight,
                contentDescription = null,
                tint = if (isNextButtonEnabled) Color.Black else Color.Black.copy(alpha = 0.3f),
                modifier = Modifier.clickable {
                    if (isNextButtonEnabled) {
                        nextPage()
                    }
                }
            )
        }
    }
}

@Composable
fun HourlyForecast(
    hourlyForecast: List<HourlyWeather>
) {
    LazyRow(
        modifier = Modifier.fillMaxSize()
    ) {
        items(hourlyForecast) { hourlyWeather ->
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.padding(8.dp)
            ) {
                // TODO: IS DAY
                val itemComposition by rememberLottieComposition(
                    LottieCompositionSpec.RawRes(
                        hourlyWeather.weatherTypeModel.weatherType.animationRes(
                            isDay = false
                        )
                    )
                )
                Text(
                    text = hourlyWeather.time.format(DateTimeFormatter.ofPattern("HH:mm")),
                    style = TempsTheme.typography.bodySmallLight
                )
                LottieAnimation(
                    composition = itemComposition,
                    modifier = Modifier.size(48.dp),
                    iterations = LottieConstants.IterateForever
                )
                // TODO: METRIC
                Text(
                    text = hourlyWeather.temperature.temperature.degrees(
                        Units.METRIC
                    ),
                    style = TempsTheme.typography.bodySmallLight
                )
            }
        }
    }
}