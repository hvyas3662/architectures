package com.hvyas.architectures.common

import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat
import com.hvyas.architectures.common.theme.ArchitecturesTheme
import com.hvyas.architectures.common.theme.component.RoundedCornerBoxButton
import com.hvyas.architectures.common.theme.component.TextTopBar
import com.hvyas.architectures.mvc.view.MvcListing
import com.hvyas.architectures.mvi.ui.screen.MviActivity
import com.hvyas.architectures.mvi_clean.ui.CleanMviActivity
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
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(12.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = modifier.fillMaxSize()
        ) {
            item {
                RoundedCornerBoxButton("MVC", onClick = { navigateToActivity(MvcListing::class.java) })
            }

            item {
                RoundedCornerBoxButton("MVVM", onClick = { navigateToActivity(MvvmActivity::class.java) })
            }

            item {
                RoundedCornerBoxButton("Clean+MVVM", onClick = { navigateToActivity(CleanMvvmActivity::class.java) })
            }

            item {
                RoundedCornerBoxButton("MVI", onClick = { navigateToActivity(MviActivity::class.java) })
            }

            item {
                RoundedCornerBoxButton("Clean+MVI", onClick = { navigateToActivity(CleanMviActivity::class.java) })
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