This is Android App that developed with Kotlin.
We can run easily this project with Android Studio Emulator.
MainAcivity.kt file is default running.

MainAcivity   --------   CalculatorView    ----------    DisplaySection
		        (CalculatorModel)       |
						|
						-----     KeypadSection     -------   KeypadButton(0~9, Del, Clear)


File Structure

test.android /  model	/DisplayState.kt
		ui	/component/DisplaySection.kt
				   KeypadButton.kt
				   KeypadSection.kt
			/intent/CalculatorIntent.kt
			/model/CalculatorModel.kt
			/view/Calculatorview.kt
		MainActivity.kt
		MyApplicationTheme.kt