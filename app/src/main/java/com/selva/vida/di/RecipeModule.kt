package com.selva.vida.di

import com.selva.vida.data.remote.services.RecipeService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RecipeModule {
    @Provides
    @Singleton
    fun provideRecipeService(): RecipeService {
        return Retrofit.Builder()
            .baseUrl(RecipeService.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RecipeService::class.java)
    }
}