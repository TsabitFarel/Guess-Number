package idn.tsabit.guessingnumber

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.cardview.widget.CardView

class MainActivity : AppCompatActivity() {

    private var startNumber: Int = 5
    private lateinit var questionText: TextView
    private lateinit var resultText: TextView
    private lateinit var buttonUp: CardView
    private lateinit var buttonDown: CardView
    private lateinit var buttonCheck: CardView
    private lateinit var buttonReset: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        questionText = findViewById(R.id.txtQuestion)
        resultText = findViewById(R.id.txtResult)
        buttonUp = findViewById(R.id.btnUp)
        buttonDown = findViewById(R.id.btnDown)
        buttonCheck = findViewById(R.id.btnCheck)
        buttonReset = findViewById(R.id.btnReset)

        buttonUp.setOnClickListener {
            onClickUp()
        }

        buttonDown.setOnClickListener {
            onClickDown()
        }

        buttonCheck.setOnClickListener {
            onClickCheck()
        }

        buttonReset.setOnClickListener {
            onClickReset()
        }

        printQuestion()
    }

    private fun onClickUp() {
        when (startNumber) {
            3 -> {
                theNumberToGuess(4)
            }
            5 -> {
                theNumberToGuess(8)
            }
            8 -> {
                theNumberToGuess(9)
            }
            9 -> {
                theNumberToGuess(10)
            }
        }
    }

    private fun onClickDown() {
        when (startNumber) {
            5 -> {
                theNumberToGuess(3)
            }
            3 -> {
                theNumberToGuess(2)
            }
            2 -> {
                theNumberToGuess(1)
            }
            8 -> {
                theNumberToGuess(7)
            }
            7 -> {
                theNumberToGuess(6)
            }
        }
    }

    private fun onClickCheck() {
        questionText.visibility = View.INVISIBLE
        resultText.visibility = View.VISIBLE
        // String format to Concatenate String and Variable startNumber
        resultText.text = String.format(resources.getString(R.string.your_number_is), startNumber)
    }

    private fun onClickReset() {
        questionText.visibility = View.VISIBLE
        resultText.visibility = View.INVISIBLE
        startNumber = 5
        printQuestion()
    }

    private fun theNumberToGuess(myNumber: Int) {
        startNumber = myNumber
        printQuestion()
    }

    private fun printQuestion() {
        // String format to Concatenate String and Variable startNumber
        questionText.text = String.format(resources.getString(R.string.is_your_number), startNumber)
    }
}