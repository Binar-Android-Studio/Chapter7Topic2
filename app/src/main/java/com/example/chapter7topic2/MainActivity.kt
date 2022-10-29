package com.example.chapter7topic2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.chapter7topic2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener(){
            throw RuntimeException("Test Crash")
        }

    }
}