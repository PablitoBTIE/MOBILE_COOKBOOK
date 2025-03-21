package com.example.mobile_cookbook

import android.content.Context.MODE_PRIVATE
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.RatingBar
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class fragment_b : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_b2, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val myRecipe = view.findViewById<EditText>(R.id.przepis_EditText)
        val recipe = view.findViewById<EditText>(R.id.opis_EditText)
        val ratingBar = view.findViewById<RatingBar>(R.id.my_ratingbar)
        val ratingValue = view.findViewById<TextView>(R.id.rating_value_textview)

//        val sharedPreferences = getSharedPreferences("MojePreferencje", MODE_PRIVATE)
//        val editor = sharedPreferences.edit()
//        val saveRatingValue = sharedPreferences.getFloat("ratingXYZ", 3.0f)
//        MyRecipe.setText(sharedPreferences.getString("myrecipe", "Brak nazwy"))
//        Recipe.setText(sharedPreferences.getString("recipe", "Brak opisu"))
       // ratingValue.text = "Twoja ocena: $saveRatingValue"

        val przepisy_TextView: TextView = view.findViewById(R.id.przepisy_TextView)
        //przepisy_TextView.text = "nazwa: ${myRecipe.t}\nopis:${recipe.text}\nocena:${saveRatingValue}"

        val btn:Button = view.findViewById(R.id.btn_AddRecipe)
        btn.setOnClickListener{
//            editor.putString("myrecipe", myRecipe.text.toString())
//            editor.putString("recipe", recipe.text.toString())
//            editor.putFloat("ratingXYZ", ratingBar.rating)
//            editor.apply()
        }



//        ratingBar.rating = saveRatingValue
//        ratingValue.text = "Twoja ocena $saveRatingValue"

     //   ratingBar.setOnRatingBarChangeListener { ratingBar, rating, fromUser ->
     //       ratingValue.text = "Twoja ocena: $rating"

//            val editor = sharedPreferences.edit()
//            editor.putFloat("ratingXYZ", rating)
//            editor.apply()
    //    }


    }

    companion object {  }
}