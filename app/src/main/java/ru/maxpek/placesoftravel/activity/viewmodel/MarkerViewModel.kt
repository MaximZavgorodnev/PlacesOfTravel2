package ru.maxpek.placesoftravel.activity.viewmodel

import androidx.lifecycle.ViewModel
import com.yandex.mapkit.geometry.Point
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import ru.maxpek.placesoftravel.activity.marker.Marker
import ru.maxpek.placesoftravel.activity.repository.MarkerRepository
import javax.inject.Inject

private val empty = Marker(
    id = 0,
    title = "",
    point = Point(59.945933, 30.320045)
)

@ExperimentalCoroutinesApi
@HiltViewModel
class MarkerViewModel @Inject constructor(
    private val repository: MarkerRepository
): ViewModel(){

}