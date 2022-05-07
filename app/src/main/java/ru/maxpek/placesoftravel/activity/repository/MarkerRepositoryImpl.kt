package ru.maxpek.placesoftravel.activity.repository

import kotlinx.coroutines.coroutineScope
import ru.maxpek.placesoftravel.activity.dao.MarkerDao
import ru.maxpek.placesoftravel.activity.marker.Marker
import javax.inject.Inject

class MarkerRepositoryImpl @Inject constructor(
    private val dao: MarkerDao):MarkerRepository {
    var nextId: Long = 0L
    var markers = listOf<Marker>()
    override suspend fun getAll() {
        try {
            coroutineScope {
                markers = dao.getAll()
            }
        } catch (e: Exception) {
            throw Exception()
        }
    }

    override suspend fun removeById(id: Long) {
        try {
            return coroutineScope {
                dao.removeById(id)
            }
        } catch (e: Exception) {
            throw Exception()
        }
    }

    override suspend fun addMarker(marker: Marker) {
        try {
            return coroutineScope {
                dao.insert(marker)
            }
        } catch (e: Exception) {
            throw Exception()
        }
    }

    override suspend fun outputMarker(id: Long): Marker {
        try {
            return coroutineScope {
                markers.first { it.id == id }
            }
        } catch (e: Exception) {
            throw Exception()
        }
    }
}