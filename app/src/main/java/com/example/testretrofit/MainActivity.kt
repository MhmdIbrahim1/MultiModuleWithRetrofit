package com.example.testretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testretrofit.adapter.MealsAdapter
import com.example.testretrofit.databinding.ActivityMainBinding
import com.example.testretrofit.util.NetworkResult
import com.example.testretrofit.viewModel.MealsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val  viewModel by viewModels<MealsViewModel>()
    private lateinit var mealsAdapter: MealsAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.getMeals("Seafood")
        observeGetMealsByCategory()
        setUpRecyclerView()
    }

    private fun observeGetMealsByCategory() {
        viewModel.mealCategories.observe(this@MainActivity) { response ->
            when(response){
                is NetworkResult.Success -> {
                    response.data?.let {
                        mealsAdapter.submitList(it.meals)
                    }
                }
                is NetworkResult.Error -> {
                    response.message?.let { message ->
                        Log.e("MealsTest", "An error occurred: $message")
                    }
                }
                is NetworkResult.Loading -> {
                    Log.d("MealsTest", "Loading...")
                }

                else -> {}
            }
        }
    }

    private fun setUpRecyclerView() {
        mealsAdapter  = MealsAdapter(listOf())
        binding.traineeChatRv.apply {
            layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
            adapter = mealsAdapter
        }
    }
}