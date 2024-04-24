package com.magzin.apibabel.ui.view

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.magzin.apibabel.databinding.ActivityMainBinding
import com.magzin.apibabel.ui.viewmodel.RickMortyViewModel

class MainActivity : ComponentActivity() {

    private lateinit var binding:ActivityMainBinding

    private val rickMortyViewModel : RickMortyViewModel by viewModels()
    private lateinit var customAdapter: CustomAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.searchView.addTextChangedListener { dataFilter ->
            val update = rickMortyViewModel.rickMortyModel.value?.filter {
                data -> data.name.lowercase().contains(dataFilter.toString().lowercase())
                    || data.episode.lowercase().contains(dataFilter.toString().lowercase())
            }
            customAdapter.updateSearch(update!!)
            Log.i("searchView :: ", dataFilter.toString())
            Log.i("update :: ", update.toString())
        }

        rickMortyViewModel.onCreate()

        rickMortyViewModel.rickMortyModel.observe(this, Observer {data ->
            customAdapter = data?.let { CustomAdapter(it) }!!
            binding.recyclerview.adapter = customAdapter
            Log.i("currentRickMorty :: ", data.toString())
        })

        binding.recyclerview.layoutManager = LinearLayoutManager(this)

        rickMortyViewModel.isLoading.observe(this, Observer {
            binding.progress.isVisible = it
        })

        //binding.viewContainer.setOnClickListener { rickMortyViewModel.randomRickMorty() }
    }
}