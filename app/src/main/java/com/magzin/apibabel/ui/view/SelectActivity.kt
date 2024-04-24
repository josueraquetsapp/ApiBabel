package com.magzin.apibabel.ui.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Toast
import com.magzin.apibabel.databinding.ActivitySelectBinding

class SelectActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySelectBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySelectBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val episodes = binding.episodes
        val characters = binding.characters

        episodes.setOnClickListener { showEpisodes() }
        characters.setOnClickListener { showCharacters() }
    }

    private fun showEpisodes() {
        startActivity(Intent(applicationContext, MainActivity::class.java))
    }

    private fun showCharacters() {
        Toast.makeText(applicationContext, "Personajes", Toast.LENGTH_SHORT).show()
    }
}