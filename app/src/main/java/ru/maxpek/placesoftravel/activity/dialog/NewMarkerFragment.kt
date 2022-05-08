package ru.maxpek.placesoftravel.activity.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.yandex.mapkit.geometry.Point
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi
import ru.maxpek.placesoftravel.activity.util.PointArg
import ru.maxpek.placesoftravel.activity.util.StringArg
import ru.maxpek.placesoftravel.activity.viewmodel.MarkerViewModel
import ru.maxpek.placesoftravel.databinding.FragmentNewMarkerBinding

@OptIn(ExperimentalCoroutinesApi::class)
@AndroidEntryPoint
class NewMarkerFragment : DialogFragment() {
    @OptIn(ExperimentalCoroutinesApi::class)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentNewMarkerBinding.inflate(inflater, container, false)
        arguments?.textArg?.let { binding.newMarker.setText(it) }
        arguments?.pointArg?.let { binding.newMarker.setText(it) }
        val viewModel: MarkerViewModel by viewModels(ownerProducer = ::requireParentFragment)

        binding.enter.setOnClickListener {
            viewModel.changeContent(binding.newMarker.text.toString())
            viewModel.addMarker()
            findNavController().navigateUp()
        }

        return binding.root
    }

    companion object {
        var Bundle.textArg: String? by StringArg
        var Bundle.pointArg: Point by PointArg
    }
}