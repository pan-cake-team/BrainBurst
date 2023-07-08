package com.pancake.brainburst.di

import android.content.Context
import androidx.room.Room
import com.pancake.brainburst.data.source.local.room.BrainBurstDataBase
import com.pancake.brainburst.data.source.local.room.DataBaseConstants
import com.pancake.brainburst.data.source.local.room.dao.BrainBurstDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LocalModule {
    @Singleton
    @Provides
    fun provideBrainBurstDataBase(@ApplicationContext context: Context) =
        Room.databaseBuilder(
            context,
            BrainBurstDataBase::class.java,
            DataBaseConstants.DATA_BASE_NAME
        ).build()

    @Singleton
    @Provides
    fun provideBrainBurstDao(dataBase: BrainBurstDataBase): BrainBurstDao =
        dataBase.brainBurstDao
}