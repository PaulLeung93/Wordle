package com.example.codepathproject1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.codepathproject1.FourLetterWordList.getRandomFourLetterWord

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var counter = 0
        var strValue = ""
        var wordToGuess = getRandomFourLetterWord()

        val button = findViewById<Button>(R.id.Guess)
        val simpleEditText = findViewById<EditText>(R.id.UserInput)
        val restartBtn = findViewById<Button>(R.id.Restart)

        val guess1 = findViewById<TextView>(R.id.Guess1Output)
        val guess1check = findViewById<TextView>(R.id.Check1Output)

        val guess2 = findViewById<TextView>(R.id.Guess2Output)
        val guess2check = findViewById<TextView>(R.id.Check2Output)

        val guess3 = findViewById<TextView>(R.id.Guess3Output)
        val guess3check = findViewById<TextView>(R.id.Check3Output)

        val correctWord = findViewById<TextView>(R.id.CorrectWord)
        val winOrLoss = findViewById<TextView>(R.id.WinOrLose)

        correctWord.visibility = View.INVISIBLE
        winOrLoss.visibility = View.INVISIBLE
        //restartBtn.visibility = View.INVISIBLE

        button.setOnClickListener()
        {
            //Guess 1
            if (counter == 0) {

                counter++
                strValue = simpleEditText.text.toString().uppercase()
                guess1.text = strValue
                guess1check.text = checkGuess(wordToGuess, strValue)
                simpleEditText.text.clear()

                if (strValue == wordToGuess) {
                    winOrLoss.text = "You Won!"
                    winOrLoss.visibility = View.VISIBLE

                    correctWord.text = wordToGuess
                    correctWord.visibility = View.VISIBLE

                    button.isClickable = false
                    button.isEnabled = false

                    restartBtn.visibility = View.VISIBLE
                }
            }

            //Guess 2
            else if (counter == 1) {

                counter++
                strValue = simpleEditText.text.toString().uppercase()
                guess2.text = strValue
                guess2check.text = checkGuess(wordToGuess, strValue)
                simpleEditText.text.clear()

                if (strValue == wordToGuess) {
                    winOrLoss.text = "You Won!"
                    winOrLoss.visibility = View.VISIBLE

                    correctWord.text = wordToGuess
                    correctWord.visibility = View.VISIBLE

                    button.isClickable = false
                    button.isEnabled = false

                    restartBtn.visibility = View.VISIBLE
                }

            }

            //Guess 3
            else if (counter == 2) {
                counter++
                strValue = simpleEditText.text.toString().uppercase()
                guess2.text = strValue
                guess2check.text = checkGuess(wordToGuess, strValue)
                simpleEditText.text.clear()

                if (strValue == wordToGuess) {
                    winOrLoss.text = "You Won!"
                    winOrLoss.visibility = View.VISIBLE

                    correctWord.text = wordToGuess
                    correctWord.visibility = View.VISIBLE

                    button.isClickable = false
                    button.isEnabled = false

                    restartBtn.visibility = View.VISIBLE
                }

                else {
                    winOrLoss.text = "You lost!"
                    winOrLoss.visibility = View.VISIBLE
                    correctWord.text = wordToGuess
                    correctWord.visibility = View.VISIBLE
                    button.isClickable = false;
                    button.isEnabled = false;
                    restartBtn.visibility = View.VISIBLE
                }

            }

        }

        restartBtn.setOnClickListener()
        {
            counter = 0
            wordToGuess = getRandomFourLetterWord()
            guess1.text = ""
            guess1check.text = ""
            guess2.text = ""
            guess2check.text = ""
            guess3.text = ""
            guess3check.text = ""
            simpleEditText.text.clear()

            button.isClickable = true;
            button.isEnabled = true;
            winOrLoss.visibility = View.INVISIBLE
            correctWord.visibility = View.INVISIBLE
        }
    }
}


/**
 * Parameters / Fields:
 *   wordToGuess : String - the target word the user is trying to guess
 *   guess : String - what the user entered as their guess
 *
 * Returns a String of 'O', '+', and 'X', where:
 *   'O' represents the right letter in the right place
 *   '+' represents the right letter in the wrong place
 *   'X' represents a letter not in the target word
 */
private fun checkGuess(wordToGuess: String, guess: String) : String {

    var result = ""
    for (i in 0..3) {
        if (guess[i] == wordToGuess[i]) {
            result += "O"
        } else if (guess[i] in wordToGuess) {
            result += "+"
        } else {
            result += "X"
        }
    }
    return result
}

