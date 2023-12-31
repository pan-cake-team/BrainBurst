package com.pancake.brainburst.di

import com.pancake.brainburst.data.source.local.UserScore
import com.pancake.brainburst.data.source.local.UserScoreManager
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {
 @Binds
 @Singleton
 abstract fun provideUserScoreManger(userScoreManager: UserScoreManager):UserScore

}