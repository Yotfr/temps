package ru.yotfr.temps.data.location

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.location.LocationManager
import android.util.Log
import androidx.core.content.ContextCompat
import com.google.android.gms.location.FusedLocationProviderClient
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.suspendCancellableCoroutine
import ru.yotfr.temps.domain.location.LocationProvider
import ru.yotfr.temps.domain.model.DataState
import ru.yotfr.temps.domain.model.place.Location
import javax.inject.Inject
import kotlin.coroutines.resume

class LocationProviderImpl @Inject constructor(
    private val locationClient: FusedLocationProviderClient,
    @ApplicationContext private val context: Context
) : LocationProvider {

    override suspend fun getCurrentLocation(): DataState<Location> {
        val hasAccessFineLocationPermission = ContextCompat.checkSelfPermission(
            context,
            Manifest.permission.ACCESS_FINE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED
        val hasAccessCoarseLocationPermission = ContextCompat.checkSelfPermission(
            context,
            Manifest.permission.ACCESS_COARSE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED
        val locationManager = context.getSystemService(Context.LOCATION_SERVICE) as LocationManager
        val isGpsEnabled = locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER) ||
                locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)
        if (!hasAccessFineLocationPermission || !hasAccessCoarseLocationPermission || !isGpsEnabled) {
            return DataState.Error(
                message = null
            )
        }

        return suspendCancellableCoroutine { continuation ->
            locationClient.lastLocation.apply {
                if (isComplete) {
                    if (isSuccessful) {
                        continuation.resume(
                            DataState.Success(
                                data = Location(
                                    latitude = result.latitude,
                                    longitude = result.longitude
                                )
                            )
                        )
                    } else {
                        continuation.resume(
                            DataState.Error(
                                message = null
                            )
                        )
                    }
                    return@suspendCancellableCoroutine
                }
                addOnSuccessListener { location ->
                    continuation.resume(
                        DataState.Success(
                            data = Location(
                                latitude = location.latitude,
                                longitude = location.longitude
                            )
                        )
                    )
                }
                addOnFailureListener {
                    continuation.resume(
                        DataState.Error(
                            message = it.message
                        )
                    )
                }
                addOnCanceledListener {
                    continuation.cancel()
                }
            }
        }
    }
}