package ru.maxpek.placesoftravel.activity.repository

import ru.maxpek.placesoftravel.activity.marker.Marker

interface MarkerRepository {
    suspend fun getAll(): List<Marker>
    suspend fun removeById(id: Long)
    suspend fun addMarker(marker: Marker)
    suspend fun outputMarker(id: Long)
}