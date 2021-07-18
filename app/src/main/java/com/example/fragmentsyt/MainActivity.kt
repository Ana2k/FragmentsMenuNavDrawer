package com.example.fragmentsyt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fragmentsyt.databinding.ActivityMain2Binding

class MainActivity : AppCompatActivity() {
    private lateinit var _binding: ActivityMain2Binding
    private val binding
        get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMain2Binding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }
}