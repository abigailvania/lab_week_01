package com.example.lab_week_01

import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nameDisplay = findViewById<TextView>(R.id.name_display)
        val nameSubmit = findViewById<Button>(R.id.name_submit)
        val nameInput = findViewById<TextInputEditText>(R.id.name_input)
        val numberInput = findViewById<TextInputEditText>(R.id.number_input)

        nameSubmit.setOnClickListener {
            val nameText = nameInput.text?.toString()?.trim().orEmpty()
            if (nameText.isNotEmpty()) {
                nameDisplay.text = "${getString(R.string.name_greet)} $nameText"
            } else {
                Toast.makeText(this, getString(R.string.name_empty), Toast.LENGTH_LONG)
                    .apply {
                        setGravity(Gravity.CENTER, 0, 0)
                        show()
                    }
            }

            val numberText = numberInput.text?.toString()?.trim().orEmpty()
            if (numberText.length != 11) {
                Toast.makeText(this, getString(R.string.number_empty), Toast.LENGTH_LONG)
                    .apply {
                        setGravity(Gravity.CENTER, 0, 0)
                        show()
                    }
            }
        }
    }
}
