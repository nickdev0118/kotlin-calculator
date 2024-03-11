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
        val currentChars = displayState.value.displayText.toMutableList()
        currentChars.add(number.toString().single())
        displayState.value = displayState.value.copy(displayText = currentChars.toCharArray())
    }

    private fun deleteLastCharacter() {
        val currentChars = displayState.value.displayText.toMutableList()
        if (currentChars.isNotEmpty()) {
            currentChars.removeAt(currentChars.size - 1)
            displayState.value = displayState.value.copy(displayText = currentChars.toCharArray())
        }
    }

    private fun clearDisplay() {
        displayState.value = displayState.value.copy(displayText = charArrayOf())
    }

    fun observeDisplayState(): MutableState<DisplayState> = displayState
}