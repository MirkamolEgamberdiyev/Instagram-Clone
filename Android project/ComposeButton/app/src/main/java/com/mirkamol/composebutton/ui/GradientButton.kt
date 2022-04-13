package com.mirkamol.composebutton.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults.buttonColors
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mirkamol.composebutton.ui.theme.Purple200

@Composable
fun GradientButton(
    text:String,
    textColor:Color,
    gradient:Brush,
    onClick: () -> Unit
) {
    Button(
        colors = buttonColors(backgroundColor = Color.Transparent),
        onClick = { onClick }) {
        Box(
            modifier = Modifier
                .background(
                gradient
                )
                .padding(horizontal = 16.dp, vertical = 8.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(text = text, color = textColor)
        }
    }
}

@Preview
@Composable
fun GradientButtonPreview() {
    GradientButton(
        "MyButton",
        Color.White,
        Brush.horizontalGradient(
            colors = listOf(Purple200, Color.Green)
        )
    ){

    }
}