package ru.maxpek.placesoftravel.activity.repository

import ru.maxpek.placesoftravel.activity.marker.Marker

interface MarkerRepository {
    suspend fun getAll()
    suspend fun removeById(id: Long)
    suspend fun addMarker(marker: Marker)
    suspend fun outputMarker(id: Long): Marker
}