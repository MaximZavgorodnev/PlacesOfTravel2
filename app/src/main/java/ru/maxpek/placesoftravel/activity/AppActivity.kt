package ru.maxpek.placesoftravel.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.maxpek.placesoftravel.R
import ru.maxpek.placesoftravel.databinding.AppActivityBinding

class AppActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = AppActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}