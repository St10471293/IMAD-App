package com.example.imadapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private var timeOfDay: EditText? = null
    private var suggestMeal: TextView? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        // Initialises the view

        timeOfDay = findViewById(R.id.timeOfDay)
        suggestMeal = findViewById(R.id.suggestMeal)

        val btnSug = findViewById<Button>(R.id.btnSug)
        val btnClr = findViewById<Button>(R.id.btnClr)
        val btnExt = findViewById<Button>(R.id.btnExt)


        // Manages the "Choose meal" button click, which suggests meals according to the timeOfDay inputted

        btnSug.setOnClickListener {
            //  if (isNotEmpty()) {
            //      val time = timeOfday?.text.toString().trim()
            chooseMeal()
            //   }
        }

        // Controls "Clear" button click, which clears the Edit text

        btnClr.setOnClickListener {
            timeOfDay?.text?.clear()
            suggestMeal?.text = ""
        }

        // Deals with "Exit" button click, which exits the app

        btnExt.setOnClickListener {
            moveTaskToBack(true)
            finish()
        }
    }

    // Function to check if timeOfDay is empty

    private fun isNotEmpty(): Boolean {
        return if (timeOfDay?.text.toString().trim().isEmpty()) {
            timeOfDay?.error = "Please enter the time of day eg.(Morning)"
            false
        } else {
            true
        }
    }

    // Function to suggest a meal based on the time of day

    private fun chooseMeal() {

        if (isNotEmpty()) {

            val suggestion = timeOfDay?.text.toString().trim().lowercase()

            when (suggestion) {
                "morning" -> suggestMeal?.text = "Breakfast: Toast, Eggs and Coffee, Scones"
                "mid-morning snack" -> suggestMeal?.text =
                    "Light snack: Fruit Smoothie, Smoothie, Energy Bar"

                "afternoon" -> suggestMeal?.text = " Lunch: Pizza, Pot Roast, Burger"
                "afternoon snack" -> suggestMeal?.text =
                    "Quick bites: Fruit Smoothie, Chocolate milk and scones, Fries"

                "dinner" -> suggestMeal?.text =
                    "Main course: Pap and Sausage, Alfredo Pasta, Steak Roll"

                "after dinner" -> suggestMeal?.text = "Dessert: Ice cream, Chcocolate cake ,Muffin"
                else -> {
                    suggestMeal?.text =
                        "Invalid time of day. Please enter Morning, Mid-morning snack, Afternoon, Afternoon snack, Dinner, After dinner"
                }

            }
            //suggestMeal?.text = suggestion
        }
    }
}


