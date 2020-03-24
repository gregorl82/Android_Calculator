package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var lastInput: String = ""
    var operation: Operation? = null
    var firstNumber: Double = 0.0
    var calculator = Calculator()
    var decimal: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_cancel.setOnClickListener {
            clearDisplays()
        }

        button_posneg.setOnClickListener {
            var current: Double = calcDisplay.text.toString().toDouble()

            current = 0 - current

            calcDisplay.text = current.toString()
        }

        button_percent.setOnClickListener {
            var current: Double = calcDisplay.text.toString().toDouble()

            current /= 100

            calcDisplay.text = current.toString()
        }

        button_num1.setOnClickListener {
            updateInputDisplay('1')
        }

        button_num2.setOnClickListener {
            updateInputDisplay('2')
        }

        button_num3.setOnClickListener {
            updateInputDisplay('3')
        }

        button_num4.setOnClickListener {
            updateInputDisplay('4')
        }

        button_num5.setOnClickListener {
            updateInputDisplay('5')
        }

        button_num6.setOnClickListener {
            updateInputDisplay('6')
        }

        button_num7.setOnClickListener {
            updateInputDisplay('7')
        }

        button_num8.setOnClickListener {
            updateInputDisplay('8')
        }

        button_num9.setOnClickListener {
            updateInputDisplay('9')
        }

        button_num0.setOnClickListener {
            if(lastInput != "") {
                updateInputDisplay('0')
            }
            lastInput = "0"
        }

        button_decimal.setOnClickListener {
            if(calcDisplay.text.toString() == "0") {
                inputDisplay.text = "0."
                decimal = true
            } else if (!decimal) {
                updateInputDisplay('.')
                decimal = true
            }

        }

        button_add.setOnClickListener {
            storeFirstNumber()
            operation = Operation.ADDITION
            clearDisplays()
        }

        button_subtract.setOnClickListener {
            storeFirstNumber()
            operation = Operation.SUBTRACTION
            clearDisplays()
        }

        button_multiply.setOnClickListener {
            storeFirstNumber()
            operation = Operation.MULTIPLICATION
            clearDisplays()
        }

        button_divide.setOnClickListener {
            storeFirstNumber()
            operation = Operation.DIVISION
            clearDisplays()
        }

        button_equals.setOnClickListener {
            val secondNumber: Double = calcDisplay.text.toString().toDouble()
            var result = 0.0

            if (operation == Operation.ADDITION) {
                result = calculator.add(firstNumber, secondNumber)
            }

            if (operation == Operation.SUBTRACTION) {
                result = calculator.subtract(firstNumber, secondNumber)
            }

            if (operation == Operation.MULTIPLICATION) {
                result = calculator.multiply(firstNumber, secondNumber)
            }

            if (operation == Operation.DIVISION) {
                result = calculator.divide(firstNumber, secondNumber)
            }

            if(isWhole(result)) {
                calcDisplay.text = result.toInt().toString()
            } else {
                calcDisplay.text = result.toString()
            }
        }
    }

    private fun updateInputDisplay(number: Char) {
        val currentDisplayText: String = calcDisplay.text.toString()

        if (currentDisplayText.length < 8) {

            if (currentDisplayText == "0") {
                calcDisplay.text = number.toString()
            } else {
                calcDisplay.text = currentDisplayText + number.toString()
            }

            lastInput = number.toString()
        }

    }

    private fun clearDisplays() {
        inputDisplay.text = " "
        calcDisplay.text = "0"
        lastInput = ""
        decimal = false
    }

    private fun storeFirstNumber() {
        val currentDisplayText: String = calcDisplay.text.toString()
        firstNumber = currentDisplayText.toDouble()
    }

    private fun isWhole(number: Double): Boolean {
        return number % 1.toDouble() == 0.toDouble()
    }

    enum class Operation{
        ADDITION,
        SUBTRACTION,
        MULTIPLICATION,
        DIVISION
    }

}
