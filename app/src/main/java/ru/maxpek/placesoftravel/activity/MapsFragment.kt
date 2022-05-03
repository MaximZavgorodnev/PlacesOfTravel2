package ru.maxpek.placesoftravel.activity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.inflate
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.yandex.mapkit.MapKitFactory
import com.yandex.mapkit.mapview.MapView
import ru.maxpek.placesoftravel.R
import ru.maxpek.placesoftravel.databinding.AppActivityBinding.inflate
import ru.maxpek.placesoftravel.databinding.FragmentMapsBinding
import ru.maxpek.placesoftravel.databinding.FragmentNewMarkerBinding.inflate

class MapsFragment() : Fragment() {
//    private lateinit var mapView: MapView
//    private lateinit var yandexMap : MapKit
//
//
//    @SuppressLint("MissingPermission")
//    private val requestPermissionLauncher =
//        registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted ->
//            if (isGranted) {
//                yandexMap.apply {
//                    this.createUserLocationLayer(mapView.findViewById(R.id.map))
//                }
//            } else {
//                // TODO: show sorry dialog
//            }
//        }

//    companion object{
//        private const val MAPKIT_API_KEY = "e0f40ead-fefb-45cf-821c-37efc0eaa548"
//    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        MapKitFactory.initialize(context)
        val binding = FragmentMapsBinding.inflate(inflater)
//        MapKitFactory.initialize(context)
//        var mapViewBundle: Bundle? = null
//        if (savedInstanceState != null) {
//            mapViewBundle = savedInstanceState.getBundle(MAPKIT_API_KEY)
//        }

//        MapKitFactory.setApiKey(MAPKIT_API_KEY)

//        mapView.onCreate(mapViewBundle)

//
//        val mapKit = MapKitFactory.getInstance();
//        mapView.apply {
//            mapKit.setApiKey(MAPKIT_API_KEY)
//
//            addView(binding.map)
//        }


        return binding.root
    }


//    override fun onStart() {
//        super.onStart()
//        MapKitFactory.getInstance().onStart()
//        mapView.onStart()
//    }
//
//    override fun onStop() {
//        super.onStop()
//        MapKitFactory.getInstance().onStop()
//        mapView.onStop()
//    }
}



public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
    View mainView = inflater.inflate(R.layout.yandex_map, container);
    return mainView;
}

View mainView = inflater.inflate(R.layout.yandex_map, null)


yandex_map.xml выглядит вот так:


<ru.yandex.yandexmapkit.MapView
android:id="@+id/map"
android:layout_width="fill_parent"
android:layout_height="fill_parent"
android:apiKey="мой ключ"
android:layout_weight="1"
/>