package ru.maxpek.placesoftravel.activity.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ru.maxpek.placesoftravel.activity.marker.Marker

@Dao
interface MarkerDao {
    @Query("SELECT * FROM Marker ORDER BY id DESC")
    fun getAll():List<Marker>

    @Query("DELETE FROM Marker WHERE id = :id")
    suspend fun removeById(id: Long)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(marker: Marker) : Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(markers: List<Marker>)
}