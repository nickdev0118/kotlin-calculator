package com.example.test.android.ui.intent

sealed class CalculatorIntent {
    data class AppendNumber(val number: Int) : CalculatorIntent()
    object DeleteLastCharacter : CalculatorIntent()
    object ClearDisplay : CalculatorIntent()
}