package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity() {

    //create Dice class, taking in number of dice sides
    class Dice (private val numSides: Int){
        //roll function returning an integer of random num betw 1-specified num of dice sides
        fun roll(): Int{
            return (1..numSides).random();
        }
    }


    /**
     * Roll 2 dice and update the screen with the results.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //initialize the dice pictures with an initial roll
        rollDice();

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener {
            rollDice();
            //NOTE: best practice: can be condensed to rollButton.setOnClickListener { rollDice() }

            //when we click rollButton, we want the textview to display 6
            //val resultTextView: TextView = findViewById(R.id.textView);
            //resultTextView.text = "6";

            //toast is a msg that appears to the user upon button click
            //val toast = Toast.makeText(this, "Dice Rolled!", Toast.LENGTH_SHORT);
            //tell the toast to display itself:
            //toast.show();
        }
    }

    /**
     * Roll the dice and update the screen with the results.
     */
    private fun rollDice() {
        //instantiate objects dice1 and dice2 of class Dice, with 6 sides
        val dice1 = Dice(6);
        val dice2 = Dice(6);

        //store the roll of dice1 and dice2 in diceRoll1 and diceRoll2 variables
        val diceRoll1 = dice1.roll();
        val diceRoll2 = dice2.roll();

        //assign the dice images in xml as diceImage1 and diceImage2 variables
        val diceImage1: ImageView = findViewById(R.id.imageView1);
        val diceImage2: ImageView = findViewById(R.id.imageView2);

        //optimized when statement using a variable for setImageResource's arg for dice1
        val drawableResource1 = when (diceRoll1){
            1 -> R.drawable.dice_1;
            2 -> R.drawable.dice_2;
            3 -> R.drawable.dice_3;
            4 -> R.drawable.dice_4;
            5 -> R.drawable.dice_5;
            else -> R.drawable.dice_6;
        }
        //optimized when statement using a variable for setImageResource's arg for dice2
        val drawableResource2 = when (diceRoll2){
            1 -> R.drawable.dice_1;
            2 -> R.drawable.dice_2;
            3 -> R.drawable.dice_3;
            4 -> R.drawable.dice_4;
            5 -> R.drawable.dice_5;
            else -> R.drawable.dice_6;
        }

        //set dice1's and dice2's imageResources to their new drawableResource1/2 variables
        diceImage1.setImageResource(drawableResource1);
        diceImage2.setImageResource(drawableResource2);

        //for screen readers to read content descriptions, set dynamic content descriptions
        diceImage1.contentDescription = diceRoll1.toString();
        diceImage2.contentDescription = diceRoll2.toString();







        /* old when statement
        when (diceRoll1) {
            1 -> diceImage.setImageResource(R.drawable.dice_1);
            2 -> diceImage.setImageResource(R.drawable.dice_2);
            3 -> diceImage.setImageResource(R.drawable.dice_3);
            4 -> diceImage.setImageResource(R.drawable.dice_4);
            5 -> diceImage.setImageResource(R.drawable.dice_5);
            6 -> diceImage.setImageResource(R.drawable.dice_6);
        };
        */

        /*instead of if else statements for a 'cascade', use when statement
        if (diceRoll1 == 1){
            diceImage.setImageResource(R.drawable.dice_1);
        } else if (diceRoll1 == 2){
            diceImage.setImageResource(R.drawable.dice_2);
        } else if (diceRoll1 == 3) {
            diceImage.setImageResource(R.drawable.dice_3);
        } else if (diceRoll1 == 4){
            diceImage.setImageResource(R.drawable.dice_4);
        } else if (diceRoll1 == 5){
            diceImage.setImageResource(R.drawable.dice_5);
        } else{
            diceImage.setImageResource(R.drawable.dice_6);
        }
        */

        //assign the bottom text view (textView) in xml as resultTextView variable
        //val resultTextView1: TextView = findViewById(R.id.textView);

        //set our resultTextView1's text to be the dice roll1 value
        //resultTextView1.text = diceRoll1.toString();  //need toString bc roll func returns int
    }
}










