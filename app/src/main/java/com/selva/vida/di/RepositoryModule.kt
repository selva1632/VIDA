package com.selva.vida.di

import com.selva.vida.data.remote.repository.RecipeRepositoryImpl
import com.selva.vida.domain.RecipeRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindRecipeRepository(repositoryImpl: RecipeRepositoryImpl): RecipeRepository
}