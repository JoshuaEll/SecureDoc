package com.example.securedoc

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Build
import android.os.Bundle
import android.security.keystore.KeyGenParameterSpec
import android.security.keystore.KeyProperties
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import java.security.KeyStore

class Register : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.password_register)
       // val ks = KeyStore.getInstance("AndroidKeyStore")
        //val result = ks.containsAlias("master_key")


        val err: TextView = findViewById(R.id.error1)
        val save = findViewById<Button>(R.id.button2)
        var pw: EditText = findViewById(R.id.editTextNumberPassword)
        //var shared = EncryptedSharedPreferences.create(this, "shared_prefs", masterKey, EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
        //EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM)
        var shared: SharedPreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE)


        save.setOnClickListener{
            var textLength = pw.text.length
            if(textLength != 4){
                err.visibility = View.VISIBLE
                err.text = "A total of 4 Numbers have to be entered!"
            }
            else{
                err.visibility = View.INVISIBLE
                var text = pw.text.toString()
                shared.edit().putString("user_pw", text).apply()
                val intent = Intent(this, LogIn::class.java).apply {

                }
                startActivity(intent)
            }

        }
    }

}