package com.example.testretrofit.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.entity.MealsByCategory
import com.example.domain.usecase.GetMealUseCase
import com.example.testretrofit.util.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MealsViewModel@Inject constructor(
    private val getMealUseCase: GetMealUseCase
): ViewModel(){

    private val _mealCategories = MutableLiveData<NetworkResult<MealsByCategory>>()

    val mealCategories: MutableLiveData<NetworkResult<MealsByCategory>>
        get() = _mealCategories


     fun getMeals(category:String){
        viewModelScope.launch {
            _mealCategories.postValue(NetworkResult.Loading())
        }

        viewModelScope.launch {
            try {
                _mealCategories.postValue(NetworkResult.Success(getMealUseCase(category)))
            }catch (e:Exception){
                _mealCategories.postValue(NetworkResult.Error("Meals not found"))
            }
        }
    }
}