package com.example.test.android.ui.view

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import com.example.test.android.ui.components.DisplaySection
import com.example.test.android.ui.components.KeypadSection
import com.example.test.android.ui.model.CalculatorModel
import com.example.test.android.ui.intent.CalculatorIntent

// This is the Layout UI.
@Composable
fun CalculatorView(calculatorModel: CalculatorModel) {
    val displayState = calculatorModel.observeDisplayState()//.collectAsState()

    Column (
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        DisplaySection(displayState.value)
        KeypadSection(
            onKeypadButtonClicked = { number ->
                calculatorModel.processIntent(CalculatorIntent.AppendNumber(number))
            },
            onDeleteClicked = {
                calculatorModel.processIntent(CalculatorIntent.DeleteLastCharacter)
            },
            onClearClicked = {
                calculatorModel.processIntent(CalculatorIntent.ClearDisplay)
            }
        )
    }
}

@Preview
@Composable
fun PreviewCalculatorView() {
    CalculatorView(CalculatorModel())
}