package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var lastInput: String = ""
    var operation: String? = null
    var firstNumber: Double = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_cancel.setOnClickListener {
            clearDisplay()
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
            updateCalcDisplay('1')
        }

        button_num2.setOnClickListener {
            updateCalcDisplay('2')
        }

        button_num3.setOnClickListener {
            updateCalcDisplay('3')
        }

        button_num4.setOnClickListener {
            updateCalcDisplay('4')
        }

        button_num5.setOnClickListener {
            updateCalcDisplay('5')
        }

        button_num6.setOnClickListener {
            updateCalcDisplay('6')
        }

        button_num7.setOnClickListener {
            updateCalcDisplay('7')
        }

        button_num8.setOnClickListener {
            updateCalcDisplay('8')
        }

        button_num9.setOnClickListener {
            updateCalcDisplay('9')
        }

        button_num0.setOnClickListener {
            if(lastInput != "") {
                updateCalcDisplay('0')
            }
        }

        button_add.setOnClickListener {
            storeFirstNumber()
            operation = "add"
            clearDisplay()
        }

        button_subtract.setOnClickListener {
            storeFirstNumber()
            operation = "subtract"
            clearDisplay()
        }

        button_multiply.setOnClickListener {
            storeFirstNumber()
            operation = "multiply"
            clearDisplay()
        }

        button_divide.setOnClickListener {
            storeFirstNumber()
            operation = "divide"
            clearDisplay()
        }

        button_equals.setOnClickListener {
            val secondNumber: Double = calcDisplay.text.toString().toDouble()

            if (operation == "add") {
                calcDisplay.text = add(firstNumber, secondNumber).toString()
            }

            if (operation == "subtract") {
                calcDisplay.text = subtract(firstNumber, secondNumber).toString()
            }

            if (operation == "multiply") {
                calcDisplay.text = multiply(firstNumber, secondNumber).toString()
            }

            if (operation == "divide") {
                calcDisplay.text = divide(firstNumber, secondNumber).toString()
            }
        }
    }

    private fun updateCalcDisplay(number: Char) {
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

    private fun clearDisplay() {
        calcDisplay.text = "0"
        lastInput = ""
    }

    private fun storeFirstNumber() {
        val currentDisplayText: String = calcDisplay.text.toString()
        firstNumber = currentDisplayText.toDouble()
    }

    // Operations

    private fun add(a: Double, b: Double): Double {
        return a + b
    }

    private fun subtract(a: Double, b: Double): Double {
        return a - b
    }

    private fun multiply(a: Double, b: Double): Double {
        return a * b
    }

    private fun divide(a: Double, b: Double): Double {
        return a / b
    }
}
