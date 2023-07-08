package com.pancake.brainburst.data.source.local.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.pancake.brainburst.data.source.local.room.entity.FavoriteQuestionEntity

@Dao
interface BrainBurstDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
  suspend fun addFavoriteQuestion(question: FavoriteQuestionEntity)

    @Query("select * from FavoriteQuestionEntity")
   suspend fun getAllFavoriteQuestions(): List<FavoriteQuestionEntity>
}