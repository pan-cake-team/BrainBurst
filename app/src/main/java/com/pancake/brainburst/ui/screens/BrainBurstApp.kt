package com.pancake.brainburst.ui.screens

import android.annotation.SuppressLint
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import com.pancake.brainburst.ui.screens.gameScreen.GameScreen
import com.pancake.brainburst.ui.screens.gameScreen.GameScreen2
import com.pancake.brainburst.ui.screens.winScreen.WinScreen
import com.pancake.brainburst.ui.theme.BrainBurstTheme

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun BrainBurstApp() {
    BrainBurstTheme() {
        Scaffold {
            GameScreen2()
        }
    }

}