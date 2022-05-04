package ru.maxpek.placesoftravel.activity

import androidx.fragment.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.yandex.mapkit.Animation
import com.yandex.mapkit.MapKit
import com.yandex.mapkit.MapKitFactory
import com.yandex.mapkit.geometry.Point
import com.yandex.mapkit.map.CameraPosition
import com.yandex.mapkit.map.InputListener
import com.yandex.mapkit.mapview.MapView
import com.yandex.mapkit.user_location.UserLocationLayer
import ru.maxpek.placesoftravel.R
import ru.maxpek.placesoftravel.databinding.FragmentMapsBinding


class MapsFragment : Fragment() {


    companion object{
        private const val MAPKIT_API_KEY = "e0f40ead-fefb-45cf-821c-37efc0eaa548"
        private lateinit var mapView: MapView
        private lateinit var mapKit: MapKit
        private val TARGET_LOCATION = Point(59.945933, 30.320045)

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MapKitFactory.setApiKey(MAPKIT_API_KEY)
        MapKitFactory.initialize(context)


    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mapKit = MapKitFactory.getInstance()
        val binding = FragmentMapsBinding.inflate(inflater, container, false)
        mapView = binding.map
        val userLocationLayer = mapKit.createUserLocationLayer(mapView.mapWindow)
        var plus = 7F

//        val camera = CameraPosition(TARGET_LOCATION, 7.0f, 0.0f, 0.0f)
        var target= mapView.map.cameraPosition.target

        val cam = mapView.map

        mapView.map.move(
            CameraPosition(TARGET_LOCATION, 7.0f, 0.0f, 0.0f),
            Animation(Animation.Type.SMOOTH, 5F),
            null
        )
//            ?: throw NullPointerException()
        mapView.map.visibleRegion.topLeft


        binding.plus.setOnClickListener {

            mapView.map.move(CameraPosition(target, plus+1F, 0.0f, 0.0f),
                Animation(Animation.Type.SMOOTH, 2F),
                null)

        }

        binding.minus.setOnClickListener {
            mapView.map.move(CameraPosition(target, plus-3F, 0.0f, 0.0f),
                Animation(Animation.Type.SMOOTH, 2F),
                null)

        }

//        val inputListener = object : InputListener {}

        return binding.root
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

//    private fun showToast(text: String) {
//        toast?.cancel()
//        toast = Toast.makeText(this, text, Toast.LENGTH_SHORT).also { it.show() }
//    }
}