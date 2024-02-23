package com.example.data.remote

import com.example.domain.entity.MealsByCategory
import retrofit2.http.GET
import retrofit2.http.Query

interface MealApi {
    @GET("filter.php")
    suspend fun getMeals(@Query("c") category: String): MealsByCategory

    @GET("lookup.php")
    suspend fun getMealById(@Query("i") id: String): MealsByCategory
}