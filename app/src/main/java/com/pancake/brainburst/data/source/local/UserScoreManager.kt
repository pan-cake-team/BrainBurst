package com.pancake.brainburst.data.source.local

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.preferencesDataStoreFile
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserScoreManager @Inject constructor(@ApplicationContext private val context: Context) :
    UserScore {
    private val dataStore: DataStore<Preferences> = PreferenceDataStoreFactory.create {
        context.preferencesDataStoreFile(USER_SCORE)
    }

    override suspend fun setHighestScore(score: Int) {
        dataStore.edit { preferences ->
            preferences[PreferencesKeys.highestScore] = score
        }
    }


    override suspend fun getHighestScore(): Int {
        return dataStore.data.map { preferences ->
            preferences[PreferencesKeys.highestScore] ?: 0
        }.first()
    }

    private companion object {
        const val USER_SCORE = "user_score"
    }
}

private object PreferencesKeys {
    val highestScore = intPreferencesKey("highest_score")
}