package ru.maxpek.placesoftravel.activity

import android.graphics.PointF
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

import com.google.android.material.snackbar.BaseTransientBottomBar
import com.google.android.material.snackbar.Snackbar
import com.yandex.mapkit.Animation
import com.yandex.mapkit.MapKit
import com.yandex.mapkit.MapKitFactory
import com.yandex.mapkit.geometry.Point
import com.yandex.mapkit.layers.GeoObjectTapListener
import com.yandex.mapkit.layers.ObjectEvent
import com.yandex.mapkit.map.*
import com.yandex.mapkit.map.Map
import com.yandex.mapkit.user_location.UserLocationLayer
import com.yandex.mapkit.user_location.UserLocationObjectListener
import com.yandex.mapkit.user_location.UserLocationView
import com.yandex.runtime.image.ImageProvider
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi
import ru.maxpek.placesoftravel.R
import ru.maxpek.placesoftravel.activity.dialog.NewMarkerFragment.Companion.pointArg
import ru.maxpek.placesoftravel.databinding.FragmentMapsBinding


@ExperimentalCoroutinesApi
@AndroidEntryPoint
class MapsFragment : Fragment(), UserLocationObjectListener {
    private var binding: FragmentMapsBinding? = null

    var mapObjects: MapObject? = null

    private val objectTapListener = GeoObjectTapListener { geo ->
        val selectionMetadata : GeoObjectSelectionMetadata =
            geo.geoObject.metadataContainer.getItem(GeoObjectSelectionMetadata::class.java)

        binding?.map?.map?.selectGeoObject(selectionMetadata.id, selectionMetadata.layerId)

        true
    }

    private val inputListener = object : InputListener {
        override fun onMapTap(map: Map, point: Point) {

        }

        override fun onMapLongTap(map: Map, point: Point) {
            if (mapObjects != null) {
                binding?.map?.map?.mapObjects?.remove(mapObjects!!)
            }
            binding?.map?.map?.deselectGeoObject()

            mapObjects = binding?.map?.map?.mapObjects?.addPlacemark(
                point,
                ImageProvider.fromResource(context, R.drawable.search_result)
            )

            Snackbar.make(
                binding?.root!!, R.string.addMarker,
                BaseTransientBottomBar.LENGTH_INDEFINITE
            ).setAction(R.string.add)
                { findNavController().navigate(R.id.action_mapsFragment_to_newMarkerFragment,
                    Bundle().apply { pointArg = point })}.show()

        }
    }

    companion object{
        private const val MAPKIT_API_KEY = "e0f40ead-fefb-45cf-821c-37efc0eaa548"
        private lateinit var mapKit: MapKit
        lateinit var userLocationLayer: UserLocationLayer

        private val TARGET_LOCATION = Point(59.945933, 30.320045)

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MapKitFactory.setApiKey(MAPKIT_API_KEY)
        MapKitFactory.initialize(this.context)
        mapKit = MapKitFactory.getInstance()
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentMapsBinding.inflate(inflater, container, false)
        this.binding = binding
        val mapView = binding.map.apply {
            map.addInputListener(inputListener)
            map.addTapListener(objectTapListener)
        }
        userLocationLayer = mapKit.createUserLocationLayer(binding.map.mapWindow!!)


//        mapView.map.move(
//            CameraPosition(TARGET_LOCATION, 14.0f, 0.0f, 0.0f),
//            Animation(Animation.Type.SMOOTH, 5F),
//            null
//        )
        binding.plus.setOnClickListener {
            mapView.map.move(CameraPosition(mapView.map.cameraPosition.target,mapView.map.cameraPosition.zoom+1,
                0.0f, 0.0f),
                Animation(Animation.Type.LINEAR, 0.5F),
                null)

        }

        binding.minus.setOnClickListener {
            mapView.map.move(CameraPosition(mapView.map.cameraPosition.target,mapView.map.cameraPosition.zoom-1,
                0.0f, 0.0f),
                Animation(Animation.Type.LINEAR, 0.5F),
                null)
        }

        binding.storage.setOnClickListener {
            findNavController().navigate(R.id.action_mapsFragment_to_listOfMarkersFragment)
        }



        return binding.root
    }

    override fun onStart() {
        super.onStart()
        MapKitFactory.getInstance().onStart()
        binding?.map?.onStart()
    }

    override fun onStop() {
        super.onStop()
        MapKitFactory.getInstance().onStop()
        binding?.map?.onStop()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    override fun onObjectAdded(userLocationView: UserLocationView) {
        userLocationLayer.setAnchor(
            PointF((binding?.map?.width()!! * 0.5).toFloat(), (binding?.map?.height()!! * 0.5).toFloat()),
            PointF((binding?.map?.width()!! * 0.5).toFloat(), (binding?.map?.height()!! * 0.83).toFloat())
        )

        userLocationView.arrow.setIcon(
            ImageProvider.fromResource(
                context, R.drawable.user_arrow
            )
        )

        val pinIcon = userLocationView.pin.useCompositeIcon()

        pinIcon.setIcon(
            "icon",
            ImageProvider.fromResource(context, R.drawable.icon),
            IconStyle().setAnchor(PointF(0f, 0f))
                .setRotationType(RotationType.ROTATE)
                .setZIndex(0f)
                .setScale(1f)
        )
    }

    override fun onObjectRemoved(userLocationView: UserLocationView) {
        TODO("Not yet implemented")
    }

    override fun onObjectUpdated(userLocationView: UserLocationView, event: ObjectEvent) {
        TODO("Not yet implemented")
    }
}

