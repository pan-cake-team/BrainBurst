package com.pancake.brainburst

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.pancake.brainburst.screens.GameScreen
import com.pancake.brainburst.ui.theme.LightBackground
import com.pancake.brainburst.ui.theme.BrainBurstTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BrainBurstTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color =  LightBackground
                ) {
                    Box(contentAlignment = Alignment.Center) {
                       GameScreen()

                    }

                }
            }
        }
    }
}

