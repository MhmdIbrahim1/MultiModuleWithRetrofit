package com.example.testretrofit.di

import com.example.domain.repo.MealRepo
import com.example.domain.usecase.GetMealUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    fun provideUseCae(mealRepo: MealRepo): GetMealUseCase {
        return GetMealUseCase(mealRepo)
    }
}