package com.example.test.android.ui.model

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.example.myandroidapp.model.DisplayState
import com.example.test.android.ui.intent.CalculatorIntent

// This is the control part.
class CalculatorModel {
    private var displayState: MutableState<DisplayState> = mutableStateOf(DisplayState())

    fun processIntent(intent: CalculatorIntent) {
        when (intent) {
            is CalculatorIntent.AppendNumber -> appendNumber(intent.number)
            CalculatorIntent.DeleteLastCharacter -> deleteLastCharacter()
            CalculatorIntent.ClearDisplay -> clearDisplay()
        }
    }

    private fun appendNumber(number: Int) {
        displayState.value = displayState.value.copy(
            displayText = displayState.value.displayText + number.toString()
        )
    }

    private fun deleteLastCharacter() {
        if (displayState.value.displayText.isNotEmpty()) {
            displayState.value = displayState.value.copy(
                displayText = displayState.value.displayText.dropLast(1)
            )
        }
    }

    private fun clearDisplay() {
        displayState.value = displayState.value.copy(displayText = "")
    }

    fun observeDisplayState(): MutableState<DisplayState> = displayState
}