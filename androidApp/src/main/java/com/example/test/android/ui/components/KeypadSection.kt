package com.example.test.android.ui.components

import KeypadButton
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

// This is keyboard section that include 0~9,"Del", "Clear" button.
@Composable
fun KeypadSection(
    onKeypadButtonClicked: (Int) -> Unit,
    onDeleteClicked: () -> Unit,
    onClearClicked: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .width(200.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
            KeypadButton(text = "1", onClick = { onKeypadButtonClicked(1) })
            KeypadButton(text = "2", onClick = { onKeypadButtonClicked(2) })
            KeypadButton(text = "3", onClick = { onKeypadButtonClicked(3) })
        }
        Spacer(modifier = Modifier.height(10.dp))
        Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
            KeypadButton(text = "4", onClick = { onKeypadButtonClicked(4) })
            KeypadButton(text = "5", onClick = { onKeypadButtonClicked(5) })
            KeypadButton(text = "6", onClick = { onKeypadButtonClicked(6) })
        }
        Spacer(modifier = Modifier.height(10.dp))
        Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
            KeypadButton(text = "7", onClick = { onKeypadButtonClicked(7) })
            KeypadButton(text = "8", onClick = { onKeypadButtonClicked(8) })
            KeypadButton(text = "9", onClick = { onKeypadButtonClicked(9) })
        }
        Spacer(modifier = Modifier.height(10.dp))
        Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
            KeypadButton(text = "0", onClick = { onKeypadButtonClicked(0) })
            KeypadButton(text = "Del", onClick = { onDeleteClicked() })
            KeypadButton(text = "Clear", onClick = { onClearClicked() })
        }
    }
}

@Preview
@Composable
fun PreviewKeypadSection() {
    KeypadSection(
        onKeypadButtonClicked = {},
        onDeleteClicked = {},
        onClearClicked = {}
    )
}