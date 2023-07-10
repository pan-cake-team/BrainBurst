package com.pancake.brainburst.di

import com.pancake.brainburst.data.source.remote.repository.TriviaRepository
import com.pancake.brainburst.data.source.remote.repository.TriviaRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindRepositoryTrivia(repository: TriviaRepositoryImpl): TriviaRepository

}