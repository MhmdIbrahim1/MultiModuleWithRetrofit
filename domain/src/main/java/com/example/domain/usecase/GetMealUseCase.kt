package com.example.domain.usecase

import com.example.domain.repo.MealRepo

class GetMealUseCase(private val mealRepo: MealRepo) {
    suspend operator fun invoke(category: String) = mealRepo.getMeal(category)
}