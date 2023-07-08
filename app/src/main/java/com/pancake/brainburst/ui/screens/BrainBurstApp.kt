package com.pancake.brainburst.ui.screens

import android.annotation.SuppressLint
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.pancake.brainburst.BrainNavGraph
import com.pancake.brainburst.ui.theme.BrainBurstTheme

@OptIn(ExperimentalMaterial3Api::class)
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