package com.hvyas.architectures.common.theme.component

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextTopBar(modifier: Modifier = Modifier, text: String, onNavigationClick: () -> Unit) {
    TopAppBar(
        title = { Text(text = text) },
        navigationIcon = {
            IconButton(onClick = onNavigationClick) {
                Icon(imageVector = Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
            }
        },
        colors = TopAppBarColors(
            containerColor = Color.Black,
            scrolledContainerColor = Color.Black,
            navigationIconContentColor = Color.White,
            actionIconContentColor = Color.Black,
            titleContentColor = Color.White
        ),
        modifier = modifier
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextTopBar(modifier: Modifier = Modifier, text: String) {
    TopAppBar(
        title = { Text(text = text) },
        colors = TopAppBarColors(
            containerColor = Color.Black,
            scrolledContainerColor = Color.Black,
            navigationIconContentColor = Color.White,
            actionIconContentColor = Color.Black,
            titleContentColor = Color.White
        ),
        modifier = modifier
    )
}