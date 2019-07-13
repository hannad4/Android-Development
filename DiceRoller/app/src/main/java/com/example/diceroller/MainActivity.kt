package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.util.*



class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton: Button = findViewById(R.id.roll_button)
        val resetButton: Button = findViewById(R.id.reset_button)
        val countUpButton: Button = findViewById(R.id.countUp_button)
        rollButton.setOnClickListener { rollDice() }
        resetButton.setOnClickListener { reset() }
        countUpButton.setOnClickListener { countUp() }

    }

    private fun rollDice() {
        val randomInt = Random().nextInt(6) + 1
        val resultText: TextView = findViewById(R.id.result_text)
        resultText.text = randomInt.toString()

    }

    private fun reset() {
        val resultText: TextView = findViewById(R.id.result_text)
        if (resultText.text == "1") {
            Toast.makeText(this,"Dice is already reset",Toast.LENGTH_SHORT).show()
        }
        else {
            resultText.text = "1"
        }

    }

    private fun countUp() {
        val resultText: TextView = findViewById(R.id.result_text)
        if (resultText.text == "6") {
            Toast.makeText(this, "Dice already maxed out", Toast.LENGTH_SHORT).show()
        }
        else {
            val increment = resultText.text.toString().toInt() + 1
            resultText.text = increment.toString()
        }
    }
}
