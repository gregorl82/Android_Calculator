package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var lastInput: String = ""
    var operation: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_cancel.setOnClickListener {
            clearDisplay()
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
    }

    private fun updateCalcDisplay(number: Char) {
        val currentDisplayText: String = calcDisplay.text.toString()
        if (currentDisplayText == "0") {
            calcDisplay.text = number.toString()
        } else {
            calcDisplay.text = currentDisplayText + number.toString()
        }
        lastInput = number.toString()
    }

    private fun clearDisplay() {
        calcDisplay.text = "0"
        lastInput = ""
    }
}
