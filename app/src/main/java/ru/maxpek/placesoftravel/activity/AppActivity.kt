package ru.maxpek.placesoftravel.activity

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.yandex.mapkit.MapKitFactory
import com.yandex.mapkit.mapview.MapView
import ru.maxpek.placesoftravel.R
import ru.maxpek.placesoftravel.databinding.AppActivityBinding


class AppActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = AppActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}