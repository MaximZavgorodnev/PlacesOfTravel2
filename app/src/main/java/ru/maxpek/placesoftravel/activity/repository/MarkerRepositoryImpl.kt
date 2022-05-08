package ru.maxpek.placesoftravel.activity.repository

import androidx.lifecycle.LiveData
import ru.maxpek.placesoftravel.activity.dao.MarkerDao
import ru.maxpek.placesoftravel.activity.marker.Marker
import javax.inject.Inject

class MarkerRepositoryImpl @Inject constructor(
    private val dao: MarkerDao):MarkerRepository {

    private val markers = dao.getAll().value
    override fun getAll(): LiveData<List<Marker>> {
        return dao.getAll()
    }

    override fun removeById(id: Long) {
        dao.removeById(id)
    }

    override fun addMarker(marker: Marker) {
        dao.insert(marker)
    }

    override fun outputMarker(id: Long): Marker {
        return markers!!.first { it.id == id }
    }
}