package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var currentInput: String = ""
    var operation: Operation? = null
    var firstInput: Double = 0.0
    var calculator = Calculator()
    var decimal: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_cancel.setOnClickListener {
            reset()
        }

        // TODO Change posneg button to display 0 instead of 0.0

        button_posneg.setOnClickListener {
            var current: Double = currentInput.toDouble()

            current = 0 - current

            if (current < 0) {
                inputDisplay.text = inputDisplay.text.toString() + " (-"
            }

            if (current > 0) {
                inputDisplay.text = inputDisplay.text.toString() + " (+"
            }

            currentInput = current.toString()


        }

        button_percent.setOnClickListener {
            var current: Double = currentInput.toDouble()

            current /= 100

            currentInput = current.toString()

            inputDisplay.text = inputDisplay.text.toString() + " %"
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
            updateInputDisplay('0')
        }

        button_decimal.setOnClickListener {

            if (!decimal && currentInput == "") {
                inputDisplay.text = '.'.toString()
                currentInput = "0."
                decimal = true
            }

            if (!decimal) {
                updateInputDisplay('.')
                decimal = true
            }

        }

        button_add.setOnClickListener {
            storeFirstInput()
            inputDisplay.text = inputDisplay.text.toString() + " +"
            operation = Operation.ADDITION
        }

        button_subtract.setOnClickListener {
            storeFirstInput()
            inputDisplay.text = inputDisplay.text.toString() + " -"
            operation = Operation.SUBTRACTION
        }

        button_multiply.setOnClickListener {
            storeFirstInput()
            inputDisplay.text = inputDisplay.text.toString() + " *"
            operation = Operation.MULTIPLICATION
        }

        button_divide.setOnClickListener {
            storeFirstInput()
            inputDisplay.text = inputDisplay.text.toString() + " /"
            operation = Operation.DIVISION
        }

        button_equals.setOnClickListener {

            inputDisplay.text = inputDisplay.text.toString() + " ="

            val secondNumber: Double = currentInput.toDouble()
            var result = 0.0

            if (operation == Operation.ADDITION) {
                result = calculator.add(firstInput, secondNumber)
            }

            if (operation == Operation.SUBTRACTION) {
                result = calculator.subtract(firstInput, secondNumber)
            }

            if (operation == Operation.MULTIPLICATION) {
                result = calculator.multiply(firstInput, secondNumber)
            }

            if (operation == Operation.DIVISION) {
                result = calculator.divide(firstInput, secondNumber)
            }

            if(isWhole(result)) {
                outputDisplay.text = result.toInt().toString()
            } else {
                outputDisplay.text = result.toString()
            }
        }
    }

    private fun updateInputDisplay(number: Char) {

        if (currentInput.length < 9) {

            val inputDisplayText: String = inputDisplay.text.toString()

            if (number != '0' || (number == '0' && inputDisplayText != "")) {
                inputDisplay.text = "${inputDisplayText} ${number}"
                currentInput += number.toString()
                Log.d("Current Input: ", currentInput)
            }

        }

    }

    private fun reset() {
        inputDisplay.text = ""
        outputDisplay.text = "0"
        currentInput = ""
        decimal = false
        operation = null
    }

    private fun storeFirstInput() {
        firstInput = currentInput.toDouble()
        currentInput = ""
        Log.d("First Input: ", firstInput.toString())
        Log.d("Current input", currentInput)
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
