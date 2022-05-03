package ru.maxpek.placesoftravel.activity.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import ru.maxpek.placesoftravel.databinding.FragmentNewMarkerBinding

class NewMarkerFragment : DialogFragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentNewMarkerBinding.inflate(inflater, container, false)
        return binding.root
    }
}