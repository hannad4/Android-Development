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
        val countButton: Button = findViewById(R.id.reset_button)
        rollButton.setOnClickListener { rollDice() }
        countButton.setOnClickListener { reset() }

    }

    public fun rollDice() {
        val randomInt = Random().nextInt(6) + 1
        val resultText: TextView = findViewById(R.id.result_text)
        resultText.text = randomInt.toString()

    }


    private fun reset() {
        val resultText: TextView = findViewById(R.id.result_text)
        if (resultText.text == "0") {
            Toast.makeText(this,"Dice is already reset",Toast.LENGTH_SHORT).show();
        }
        else {
            resultText.text = "0"
        }

    }
}
