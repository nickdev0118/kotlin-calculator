package com.example.test.android.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myandroidapp.model.DisplayState

// This is the part that display the numbers.
@Composable
fun DisplaySection(displayState: DisplayState) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .background(Color.LightGray)
            .padding(16.dp)
    ) {
        Text(
            text = displayState.displayText,
            modifier = Modifier.fillMaxWidth(),
            color = Color.Black,
            fontSize = 30.sp,
            textAlign = TextAlign.Center
        )
    }
}

@Preview
@Composable
fun PreviewDisplaySection() {
    DisplaySection(DisplayState(charArrayOf('1', '2', '3', '4', '5')))
}