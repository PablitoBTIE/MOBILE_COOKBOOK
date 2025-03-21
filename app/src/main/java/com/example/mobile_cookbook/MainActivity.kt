package com.example.mobile_cookbook

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RatingBar
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var ratingBar: RatingBar
    private lateinit var ratingValue: TextView

    lateinit var MyRecipe: EditText
    lateinit var Recipe: EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        MyRecipe = findViewById(R.id.przepis_EditText)
        Recipe = findViewById(R.id.opis_EditText)
        ratingBar = findViewById(R.id.my_ratingbar)
        ratingValue = findViewById(R.id.rating_value_textview)

        val sharedPreferences = getSharedPreferences("MojePreferencje", MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        val saveRatingValue = sharedPreferences.getFloat("ratingXYZ", 3.0f)
        MyRecipe.setText(sharedPreferences.getString("myrecipe", "Brak nazwy"))
        Recipe.setText(sharedPreferences.getString("recipe", "Brak opisu"))
        ratingValue.text = "Twoja ocena: $saveRatingValue"

        val przepisy_TextView: TextView = findViewById(R.id.przepisy_TextView)
        przepisy_TextView.text = "nazwa: ${MyRecipe.text}\nopis:${Recipe.text}\nocena:${saveRatingValue}"

        val btn:Button = findViewById(R.id.btn_AddRecipe)
        btn.setOnClickListener{
            editor.putString("myrecipe", MyRecipe.text.toString())
            editor.putString("recipe", Recipe.text.toString())
            editor.putFloat("ratingXYZ", ratingBar.rating)
            editor.apply()
        }



        ratingBar.rating = saveRatingValue
        ratingValue.text = "Twoja ocena $saveRatingValue"

        ratingBar.setOnRatingBarChangeListener { ratingBar, rating, fromUser ->
            ratingValue.text = "Twoja ocena: $rating"

            val editor = sharedPreferences.edit()
            editor.putFloat("ratingXYZ", rating)
            editor.apply()
        }

//        val switchToWroc_do_activity_main_Button: Button = findViewById(R.id.idz_do_fragmentu_b)
//        switchToWroc_do_activity_main_Button.setOnClickListener {
//            parentFragmentManager.beginTransaction()
//                .setCustomAnimations(
//                    R.anim.slide_in_right,
//                    R.anim.slide_in_left
//                )
//                .replace(R.id.fragment_container, Wroc_do_activity_main_Button())
//                .addToBackStack(null)
//                .commit()

    }
}