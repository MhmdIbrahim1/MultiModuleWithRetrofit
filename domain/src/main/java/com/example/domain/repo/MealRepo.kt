package com.example.domain.repo

import com.example.domain.entity.MealsByCategory

interface MealRepo {
    suspend fun getMeal(category: String): MealsByCategory

    suspend fun getMealById(id: String): MealsByCategory
}