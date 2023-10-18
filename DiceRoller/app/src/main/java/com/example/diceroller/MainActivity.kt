package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

/**
 *
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // code added specific to my app
        val rollbutton: Button = findViewById(R.id.button)
        rollbutton.setOnClickListener { rollDice() }

        //do a dice roll when the app
        rollDice()
    }

    private fun rollDice() {
        //creating a 6 sided dice and rolling it
        val dice = Dice(6)
        val diceRoll = dice.roll()

        //updating the result on the screen
        val diceImage : ImageView = findViewById(R.id.imageView)

        //determine which drawable resource id to use based on dice roll
        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        //update the image view with the correct image
        diceImage.setImageResource(drawableResource)

        //update the content description for vision impaired ppl
        diceImage.contentDescription = diceRoll.toString()
    }
}

class Dice(private val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}