package ru.maxpek.placesoftravel.viewmodel

import androidx.lifecycle.*
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
    private val repository: MarkerRepository): ViewModel() {

    private val edited = MutableLiveData(empty)
    var nextId: Long = 0L
    var point: Point = Point(0.0,0.0)
    val data = repository.getAll()




    fun removeById(id: Long){
        repository.removeById(id)
    }

    fun addMarker(){
        edited.value?.let {
            repository.addMarker(it)
        }
        edited.value = empty
    }

    fun edit(marker: Marker){
        edited.value = marker
    }
    fun outputMarker(id: Long): Marker {
        return repository.outputMarker(id)
    }

    fun changeContent(content: String) {
        val text = content.trim()
        if (edited.value?.title == text) {
            return
        }
        edited.value = edited.value?.copy(id = nextId, title = text, point)
        nextId++
    }



}