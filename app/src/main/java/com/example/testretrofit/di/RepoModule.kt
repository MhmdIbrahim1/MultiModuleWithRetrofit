package com.example.testretrofit.di

import com.example.data.remote.MealApi
import com.example.data.repo.MealRepoImpl
import com.example.domain.repo.MealRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepoModule {

    @Provides
    fun provideRepo(mealApi: MealApi): MealRepo {
        return MealRepoImpl(mealApi)
    }
}