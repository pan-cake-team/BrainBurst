package com.pancake.brainburst.ui.main

import android.annotation.SuppressLint
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.pancake.brainburst.ui.navigation.BrainNavGraph
import com.pancake.brainburst.ui.theme.BrainBurstTheme

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun BrainBurstApp() {
    BrainBurstTheme() {
        Scaffold {
            val navController = rememberNavController()
            BrainNavGraph(navController)
        }
    }

}