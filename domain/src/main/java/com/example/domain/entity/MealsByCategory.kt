package com.example.domain.entity


import com.google.gson.annotations.SerializedName

data class MealsByCategory(
    @SerializedName("meals")
    val meals: List<Meal>
)