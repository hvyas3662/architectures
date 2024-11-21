package com.hvyas.architectures.common.theme.component

import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun EditTextCompose(modifier: Modifier = Modifier, label: String, value: String = "", onChange: (String) -> Unit) {
    OutlinedTextField(value = value, onValueChange = onChange, label = { Text(label) }, modifier = modifier)
}