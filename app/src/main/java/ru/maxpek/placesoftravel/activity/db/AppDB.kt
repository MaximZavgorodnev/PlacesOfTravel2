package ru.maxpek.placesoftravel.activity.db


import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import ru.maxpek.placesoftravel.activity.dao.MarkerDao
import ru.maxpek.placesoftravel.activity.marker.Marker

@Database(entities = [Marker::class], version = 1, exportSchema = false)
abstract class AppDb : RoomDatabase() {
    abstract fun markerDao(): MarkerDao
}