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
    }

    private fun updateCalcDisplay(number: Char) {
        val currentDisplayText: String = calcDisplay.text.toString()
        if (currentDisplayText == "0") {
            calcDisplay.text = number.toString()
        } else {
            calcDisplay.text = currentDisplayText + number.toString()
        }
    }

    private fun clearDisplay() {
        calcDisplay.text = "0"
    }
}
