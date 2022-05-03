package ru.maxpek.placesoftravel.activity

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.yandex.mapkit.MapKitFactory
import com.yandex.mapkit.mapview.MapView
import ru.maxpek.placesoftravel.R
import ru.maxpek.placesoftravel.databinding.AppActivityBinding


class AppActivity : AppCompatActivity(){
    companion object{
        private const val MAPKIT_API_KEY = "e0f40ead-fefb-45cf-821c-37efc0eaa548"
        private lateinit var mapView: MapView
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = AppActivityBinding.inflate(layoutInflater)
//        MapKitFactory.setApiKey(MAPKIT_API_KEY)
//        MapKitFactory.initialize(this)
//
//        setContentView(R.layout.fragment_maps)
//        mapView = findViewById<View>(R.id.map) as MapView
//        mapview.getMap().move(
//            CameraPosition(Point(55.751574, 37.573856), 11.0f, 0.0f, 0.0f),
//            Animation(Animation.Type.SMOOTH, 0),
//            null
//        )
        setContentView(binding.root)
//        val mapKit = MapKitFactory.getInstance()
    }

        override fun onStart() {
        super.onStart()
        MapKitFactory.getInstance().onStart()
        mapView.onStart()
    }

    override fun onStop() {
        super.onStop()
        MapKitFactory.getInstance().onStop()
        mapView.onStop()
    }
}