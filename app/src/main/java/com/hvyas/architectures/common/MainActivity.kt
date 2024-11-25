package com.hvyas.architectures.common

import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.WindowCompat
import com.hvyas.architectures.common.theme.ArchitecturesTheme
import com.hvyas.architectures.common.theme.component.TextTopBar
import com.hvyas.architectures.mvc.view.MvcListing
import com.hvyas.architectures.mvi.ui.screen.MviActivity
import com.hvyas.architectures.mvvm.ui.screen.MvvmActivity
import com.hvyas.architectures.mvvm_clean.ui.CleanMvvmActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        WindowCompat.getInsetsController(window, window.decorView).apply {
            isAppearanceLightStatusBars = false
        }
        setContent {
            ArchitecturesTheme {
                Scaffold(modifier = Modifier.fillMaxSize(), topBar = { TextTopBar(text = "Select Architecture") }) { innerPadding ->
                    ButtonSelector(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }

    @Composable
    fun ButtonSelector(modifier: Modifier = Modifier) {
        Column(modifier = modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {

            Button(onClick = { navigateToActivity(MvcListing::class.java) }) {
                Text(text = "MVC")
            }

            Button(onClick = { navigateToActivity(MviActivity::class.java) }) {
                Text(text = "MVI")
            }

            Button(onClick = { navigateToActivity(MvvmActivity::class.java) }) {
                Text(text = "MVVM")
            }

            Button(onClick = { navigateToActivity(CleanMvvmActivity::class.java) }) {
                Text(text = "Clean+MVVM")
            }

            Button(onClick = { navigateToActivity(com.hvyas.architectures.mvi_clean.ui.CleanMviActivity::class.java) }) {
                Text(text = "Clean+MVI")
            }
        }
    }

    private fun navigateToActivity(clazz: Class<*>) {
        startActivity(Intent(this, clazz))
    }

    @Preview
    @Composable
    fun GreetingPreview() {
        ArchitecturesTheme {
            ButtonSelector()
        }
    }
}