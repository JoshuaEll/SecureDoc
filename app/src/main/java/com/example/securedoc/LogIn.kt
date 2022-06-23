package com.example.securedoc

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class LogIn :  AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)
        val submit: Button = findViewById(R.id.button)
        var text: EditText = findViewById(R.id.numPassword)
        var error: EditText = findViewById(R.id.error)
        var shared: SharedPreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE)
        var string = shared.getString("user_pw","")
        submit.setOnClickListener{
            var textLength = text.text.length
            if (text.text.toString() == string.toString())
            {
                error.visibility = View.INVISIBLE
                val intent = Intent(this, MainActivity::class.java).apply {
                }
                startActivity(intent)

            }
            else
            {
                error.visibility = View.VISIBLE
                error.setText(string)
            }
        }

    }
}


