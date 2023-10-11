package ru.yotfr.temps.ui.forecast

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import ru.yotfr.temps.R
import ru.yotfr.temps.ui.theme.TempsTheme

@Composable
fun BriefDetails(
    temperature: String,
    pressure: String,
    humidity: String,
    visibility: String
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        BriefCard(
            modifier = Modifier.weight(1f),
            iconPainter = painterResource(id = R.drawable.ic_thermometer),
            value = temperature,
            description = stringResource(id = R.string.feels_like)
        )
        Spacer(modifier = Modifier.width(8.dp))
        BriefCard(
            modifier = Modifier.weight(1f),
            iconPainter = painterResource(id = R.drawable.ic_barometer),
            value = pressure,
            description = stringResource(id = R.string.pressure)
        )
    }
    Spacer(modifier = Modifier.height(8.dp))
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        BriefCard(
            modifier = Modifier.weight(1f),
            iconPainter = painterResource(id = R.drawable.ic_visibility),
            value = visibility,
            description = stringResource(id = R.string.visibility)
        )
        Spacer(modifier = Modifier.width(8.dp))
        BriefCard(
            modifier = Modifier.weight(1f),
            iconPainter = painterResource(id = R.drawable.ic_humidity),
            value = humidity,
            description = stringResource(id = R.string.humidity)
        )
    }
}

@Composable
fun BriefCard(
    modifier: Modifier,
    iconPainter: Painter,
    value: String,
    description: String
) {
    Surface(
        modifier = modifier,
        shape = RoundedCornerShape(16.dp),
        border = BorderStroke(1.dp, SolidColor(Color.Black)),
        color = Color.Transparent
    ) {
        Row(
            modifier = Modifier.padding(8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Icon(
                painter = iconPainter,
                contentDescription = null
            )
            Column(
                horizontalAlignment = Alignment.Start,
            ) {
                Text(
                    text = value,
                    style = TempsTheme.typography.bodySmallRegular
                )
                Text(
                    text = description,
                    style = TempsTheme.typography.bodySmallLight
                )
            }
        }
    }
}