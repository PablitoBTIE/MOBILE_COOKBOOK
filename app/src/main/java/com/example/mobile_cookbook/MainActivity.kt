package com.example.mobile_cookbook

import android.os.Bundle
import android.widget.RatingBar
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var ratingBar: RatingBar
    private lateinit var ratingValue: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        ratingBar = findViewById(R.id.my_ratingbar)
        ratingValue = findViewById(R.id.rating_value_textview)

        val sharedPreferences = getSharedPreferences("MojePreferencje", MODE_PRIVATE)
        val saveRatingValue = sharedPreferences.getFloat("ratingXYZ", 3.0f)

        ratingBar.rating = saveRatingValue
        ratingValue.text = "Twoja ocena $saveRatingValue"

        ratingBar.setOnRatingBarChangeListener { ratingBar, rating, fromUser ->
            ratingValue.text = "Twoja ocena: $rating"

            val editor = sharedPreferences.edit()
            editor.putFloat("ratingXYZ", rating)
            editor.apply()
        }
    }
}