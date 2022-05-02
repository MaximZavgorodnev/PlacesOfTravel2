package ru.maxpek.placesoftravel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.maxpek.placesoftravel.databinding.AppActivityBinding

class AppActivity : AppCompatActivity(R.layout.activity_app){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = AppActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}