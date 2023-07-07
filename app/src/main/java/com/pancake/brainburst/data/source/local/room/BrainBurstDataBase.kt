package com.pancake.brainburst.data.source.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.pancake.brainburst.data.source.local.room.dao.BrainBurstDao
import com.pancake.brainburst.data.source.local.room.entity.FavoriteQuestionEntity

@Database(entities = [FavoriteQuestionEntity::class], version = 1)
abstract class BrainBurstDataBase : RoomDatabase() {
    abstract val brainBurstDao: BrainBurstDao
}