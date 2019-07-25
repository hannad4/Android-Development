package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import java.util.*



class MainActivity : AppCompatActivity() {

    lateinit var diceImage1 : ImageView          // Defining bunch of promises because constant ID indexing is taxing
    lateinit var diceImage2 : ImageView
    lateinit var rollButton: Button
    lateinit var resetButton: Button
    lateinit var countUpButton: Button
    lateinit var resetToast: Toast          // Creating toast here because gravity method will be applied to it

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)     // Forcing dark theme cuz dark theme for the win :)
        setContentView(R.layout.activity_main)

        diceImage1 = findViewById(R.id.dice_image1)
        diceImage2 = findViewById(R.id.dice_image2)
        rollButton = findViewById(R.id.roll_button)
        resetButton = findViewById(R.id.reset_button)
        countUpButton = findViewById(R.id.countUp_button)

        rollButton.setOnClickListener { rollDice() }
        resetButton.setOnClickListener { reset() }
        countUpButton.setOnClickListener { countUp() }
    }

    private fun rollDice() {
        val randomInt1 = Random().nextInt(6) + 1     // Die needs to be between 0-5 (add 1 to make it "normal" 1-6)
        val randomInt2 = Random().nextInt(6) + 1
        val drawableResource = when (randomInt1) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            6 -> R.drawable.dice_6
            else -> R.drawable.empty_dice       // Only using empty vector image as fail safe (see comment below as well)
        }
        diceImage1.setImageResource(drawableResource)

        val drawableResource2 = when (randomInt2) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            6 -> R.drawable.dice_6
            else -> R.drawable.empty_dice       // Only using empty vector image as fail safe (see comment below as well)
        }
        diceImage2.setImageResource(drawableResource2)

        when (randomInt1) {          // Tags are used to keep track of current image source (no getImageSrc() exists)
            1 -> diceImage1.tag = "R.drawable.dice_1"
            2 -> diceImage1.tag = "R.drawable.dice_2"
            3 -> diceImage1.tag = "R.drawable.dice_3"
            4 -> diceImage1.tag = "R.drawable.dice_4"
            5 -> diceImage1.tag = "R.drawable.dice_5"
            6 -> diceImage1.tag = "R.drawable.dice_6"
            else -> diceImage1.tag = "R.drawable.dice_empty"     // The empty vector xml seems confusing. Only going to use it as fail safe
        }

        when (randomInt2) {          // Tags are used to keep track of current image source (no getImageSrc() exists)
            1 -> diceImage2.tag = "R.drawable.dice_1"
            2 -> diceImage2.tag = "R.drawable.dice_2"
            3 -> diceImage2.tag = "R.drawable.dice_3"
            4 -> diceImage2.tag = "R.drawable.dice_4"
            5 -> diceImage2.tag = "R.drawable.dice_5"
            6 -> diceImage2.tag = "R.drawable.dice_6"
            else -> diceImage2.tag = "R.drawable.dice_empty"     // The empty vector xml seems confusing. Only going to use it as fail safe
        }
    }

    private fun reset() {
        diceImage1.setImageResource(R.drawable.dice_1)
        diceImage1.tag = "R.drawable.dice_1"                 // Image resource is changed to first die, tag should keep track of that
        diceImage2.setImageResource(R.drawable.dice_1)
        diceImage2.tag = "R.drawable.dice_1"

        resetToast = Toast.makeText(this,"Dice reset", Toast.LENGTH_SHORT)      // Notify user of reset
        resetToast.setGravity(Gravity.BOTTOM, 0, 24)      // Different android models place this in weird locations. Way to fix?
        resetToast.show()
    }

    private fun countUp() {
        val countUp = when (diceImage1.tag) {        // Use tag to know current source so next number can be displayed
            "R.drawable.dice_1" -> R.drawable.dice_2
            "R.drawable.dice_2" -> R.drawable.dice_3
            "R.drawable.dice_3" -> R.drawable.dice_4
            "R.drawable.dice_4" -> R.drawable.dice_5
            "R.drawable.dice_5" -> R.drawable.dice_6
            "R.drawable.dice_6" -> R.drawable.dice_6   // Dice is maxed out. Can't count past 6 on dice!
            else -> R.drawable.empty_dice
        }
        diceImage1.setImageResource(countUp)        // Set the new source so that updated die is shown to user

        diceImage1.tag = when (diceImage1.tag) {      // Image resource was just updated. tag needs to keep up by updating itself too
            "R.drawable.dice_1" -> "R.drawable.dice_2"
            "R.drawable.dice_2" -> "R.drawable.dice_3"
            "R.drawable.dice_3" -> "R.drawable.dice_4"
            "R.drawable.dice_4" -> "R.drawable.dice_5"
            "R.drawable.dice_5" -> "R.drawable.dice_6"
            "R.drawable.dice_6" -> "R.drawable.dice_6" // Dice is maxed out. Can't count past 6 on a dice!
            else -> "R.drawable.dice_empty"
        }

        val countUp2 = when (diceImage2.tag) {        // Use tag to know current source so next number can be displayed
            "R.drawable.dice_1" -> R.drawable.dice_2
            "R.drawable.dice_2" -> R.drawable.dice_3
            "R.drawable.dice_3" -> R.drawable.dice_4
            "R.drawable.dice_4" -> R.drawable.dice_5
            "R.drawable.dice_5" -> R.drawable.dice_6
            "R.drawable.dice_6" -> R.drawable.dice_6   // Dice is maxed out. Can't count past 6 on dice!
            else -> R.drawable.empty_dice
        }
        diceImage2.setImageResource(countUp2)        // Set the new source so that updated die is shown to user

        diceImage2.tag = when (diceImage2.tag) {      // Image resource was just updated. tag needs to keep up by updating itself too
            "R.drawable.dice_1" -> "R.drawable.dice_2"
            "R.drawable.dice_2" -> "R.drawable.dice_3"
            "R.drawable.dice_3" -> "R.drawable.dice_4"
            "R.drawable.dice_4" -> "R.drawable.dice_5"
            "R.drawable.dice_5" -> "R.drawable.dice_6"
            "R.drawable.dice_6" -> "R.drawable.dice_6" // Dice is maxed out. Can't count past 6 on a dice!
            else -> "R.drawable.dice_empty"
        }
    }
}