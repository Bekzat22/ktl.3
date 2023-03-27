package com.example.myapplication.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.fragments.DogFragment
import com.example.myapplication.fragments.FragmentCat
import com.example.myapplication.fragments.MovieFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.cat.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.Fragment_container, FragmentCat())
                .commit()
        }

        binding.dog.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.Fragment_container, DogFragment())
                .commit()
        }
        binding.movie.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.Fragment_container, MovieFragment())
                .commit()
        }
    }
}