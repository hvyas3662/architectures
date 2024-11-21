package com.hvyas.architectures.common.theme.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp

@Composable
fun Heading1(modifier: Modifier = Modifier, text: String) {
    Box(
        modifier = modifier
            .height(48.dp)
            .fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            modifier = Modifier.fillMaxWidth(),
            fontSize = TextUnit(24f, TextUnitType.Sp),
            fontWeight = FontWeight.Bold,

        )
    }
}

@Composable
fun Heading2(modifier: Modifier = Modifier, text: String) {
    Text(text = text, modifier = modifier, fontSize = TextUnit(22f, TextUnitType.Sp), fontWeight = FontWeight.Bold)
}

@Composable
fun Heading3(modifier: Modifier = Modifier, text: String) {
    Text(text = text, modifier = modifier, fontSize = TextUnit(20f, TextUnitType.Sp), fontWeight = FontWeight.Bold)
}

@Composable
fun Heading4(modifier: Modifier = Modifier, text: String) {
    Text(text = text, modifier = modifier, fontSize = TextUnit(18f, TextUnitType.Sp), fontWeight = FontWeight.Bold)
}

@Composable
fun Heading5(modifier: Modifier = Modifier, text: String) {
    Text(text = text, modifier = modifier, fontSize = TextUnit(16f, TextUnitType.Sp), fontWeight = FontWeight.Bold)
}

@Composable
fun Heading6(modifier: Modifier = Modifier, text: String) {
    Text(text = text, modifier = modifier, fontSize = TextUnit(14f, TextUnitType.Sp), fontWeight = FontWeight.Bold)
}
