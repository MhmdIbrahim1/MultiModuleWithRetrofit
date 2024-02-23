package com.example.data.repo

import com.example.data.remote.MealApi
import com.example.domain.entity.MealsByCategory
import com.example.domain.repo.MealRepo

class MealRepoImpl(private val mealApi: MealApi): MealRepo {

    override suspend fun getMeal(category: String): MealsByCategory {
        return mealApi.getMeals(category)
    }
}