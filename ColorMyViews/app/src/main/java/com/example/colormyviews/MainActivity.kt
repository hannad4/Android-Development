package com.example.colormyviews

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setListeners()
    }


    private fun makeColored(view: View) {
        when(view.id) {
            R.id.box_one_text -> view.setBackgroundColor(Color.RED)
            R.id.box_two_text -> view.setBackgroundColor(Color.argb(255,175,20,160))
            R.id.box_three_text -> view.setBackgroundColor(Color.BLACK)
            R.id.box_four_text -> view.setBackgroundColor(Color.MAGENTA)
            R.id.box_five_text -> view.setBackgroundColor(Color.BLUE)
            R.id.red_button -> box_three_text.setBackgroundResource(R.color.my_red)
            R.id.yellow_button -> box_four_text.setBackgroundResource(R.color.my_yellow)
            R.id.green_button -> box_five_text.setBackgroundResource(R.color.my_green)

            else -> view.setBackgroundColor(Color.WHITE)
        }


    }

    private fun setListeners() {
        val boxOneText = findViewById<TextView>(R.id.box_one_text)
        val boxTwoText = findViewById<TextView>(R.id.box_two_text)
        val boxThreeText = findViewById<TextView>(R.id.box_three_text)
        val boxFourText = findViewById<TextView>(R.id.box_four_text)
        val boxFiveText = findViewById<TextView>(R.id.box_five_text)
        val rootConstraintLayout = findViewById<View>(R.id.constraint_layout)
        val redButton = findViewById<View>(R.id.red_button)
        val yellowButton = findViewById<View>(R.id.yellow_button)
        val greenButton = findViewById<View>(R.id.green_button)

        val clickableViews: List<View> = listOf(boxOneText, boxTwoText, boxThreeText, boxFourText, boxFiveText, rootConstraintLayout, redButton, yellowButton, greenButton)

        for (item in clickableViews) {
            item.setOnClickListener { makeColored(it) }
        }
    }
}
