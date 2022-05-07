package ru.maxpek.placesoftravel.activity.repository

import ru.maxpek.placesoftravel.activity.dao.MarkerDao
import ru.maxpek.placesoftravel.activity.marker.Marker
import javax.inject.Inject

class MarkerRepositoryImpl @Inject constructor(
    private val dao: MarkerDao):MarkerRepository {
    override suspend fun getAll(): List<Marker> {
        TODO("Not yet implemented")
    }

    override suspend fun removeById(id: Long) {
        TODO("Not yet implemented")
    }

    override suspend fun addMarker(marker: Marker) {
        TODO("Not yet implemented")
    }

    override suspend fun outputMarker(id: Long) {
        TODO("Not yet implemented")
    }
}