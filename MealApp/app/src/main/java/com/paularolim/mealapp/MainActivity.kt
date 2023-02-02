package com.paularolim.mealapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.paularolim.mealapp.adapters.MainAdapter
import com.paularolim.mealapp.databinding.ActivityMainBinding
import com.paularolim.mealapp.repositories.MainRepository
import com.paularolim.mealapp.services.RetrofitService
import com.paularolim.mealapp.viewmodel.MainViewModel
import com.paularolim.mealapp.viewmodel.MainViewModelFactory

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private lateinit var viewModel: MainViewModel

    private val retrofitService = RetrofitService.getInstance()
    private val adapter = MainAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel =
            ViewModelProvider(this, MainViewModelFactory(MainRepository(retrofitService))).get(
                MainViewModel::class.java
            )

        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        Log.d("MainActivity", adapter.itemCount.toString())

        viewModel.categories.observe(this, Observer {
            Log.d("MainActivity", "onCreate: list added")
            adapter.setCategoryList(it)
        })

        viewModel.loading.observe(this, Observer {
            binding.progressBar.visibility = if (it) View.VISIBLE else View.INVISIBLE
            binding.recyclerView.visibility = if (it) View.INVISIBLE else View.VISIBLE
        })

        viewModel.errorMessage.observe(this, Observer {
            binding.errorMessage.visibility = if (it.isNotEmpty()) View.VISIBLE else View.INVISIBLE
        })
        viewModel.getCategories()
    }
}