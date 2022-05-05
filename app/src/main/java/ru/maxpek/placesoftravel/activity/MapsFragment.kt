package ru.maxpek.placesoftravel.activity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.yandex.mapkit.Animation
import com.yandex.mapkit.MapKit
import com.yandex.mapkit.MapKitFactory
import com.yandex.mapkit.geometry.Point
import com.yandex.mapkit.layers.ObjectEvent
import com.yandex.mapkit.map.CameraPosition
import com.yandex.mapkit.map.InputListener
import com.yandex.mapkit.mapview.MapView
import com.yandex.mapkit.map.Map
import com.yandex.mapkit.user_location.UserLocationObjectListener
import com.yandex.mapkit.user_location.UserLocationView
import ru.maxpek.placesoftravel.databinding.FragmentMapsBinding
import android.content.Context
import com.yandex.runtime.image.ImageProvider

import ru.maxpek.placesoftravel.R


//UserLocationObjectListener

class MapsFragment : Fragment()  {
    private lateinit var mapView: MapView
    private lateinit var mapKit: MapKit



    companion object{
        private const val MAPKIT_API_KEY = "e0f40ead-fefb-45cf-821c-37efc0eaa548"

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
        val inputListener = object : InputListener {
            override fun onMapTap(map: Map, point: Point) {
                map.visibleRegion



                mapView.map.mapObjects.addPlacemark(
                    point, ImageProvider.fromResource(context, R.drawable.ic_baseline_add_location_48)
                )

                binding.button.visibility = View.VISIBLE
            }

            override fun onMapLongTap(map: Map, point: Point) {
                // point - точка на карте
                binding.button.visibility = View.GONE
                mapView.map.mapObjects.addPlacemark(
                    point, ImageProvider.fromResource(context, R.drawable.ic_baseline_add_location_48)
                )


            }
        }
        mapView.map.addInputListener(inputListener)




        val userLocationLayer = mapKit.createUserLocationLayer(mapView.mapWindow)
        var plus = 7F

        val camera = CameraPosition(TARGET_LOCATION, 7.0f, 0.0f, 0.0f)
//        var target= userLocationLayer.cameraPosition()?.target ?: throw NullPointerException()

        userLocationLayer.isVisible
        val cam = mapView.map

        mapView.map.move(
            CameraPosition(TARGET_LOCATION, 14.0f, 0.0f, 0.0f),
            Animation(Animation.Type.SMOOTH, 5F),
            null
        )
        binding.plus.setOnClickListener {
            mapView.map.move(CameraPosition(mapView.map.cameraPosition.target,mapView.map.cameraPosition.zoom+1,
                0.0f, 0.0f),
                Animation(Animation.Type.SMOOTH, 2F),
                null)

        }

        binding.minus.setOnClickListener {
            mapView.map.move(CameraPosition(mapView.map.cameraPosition.target,mapView.map.cameraPosition.zoom-1,
                0.0f, 0.0f),
                Animation(Animation.Type.SMOOTH, 2F),
                null)
        }



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



}

