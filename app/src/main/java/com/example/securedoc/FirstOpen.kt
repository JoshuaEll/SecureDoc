package com.example.securedoc

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity



class FirstOpen : AppCompatActivity() {

    private lateinit var editor : SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if(firstTime())
        {
            val intent = Intent(this, Register::class.java).apply {

            }
            editor = getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
            editor.edit().putBoolean("first_time", false).apply()
            startActivity(intent)

        }
        else
        {
            val intent = Intent(this, LogIn::class.java).apply{

            }
            startActivity(intent)

        }

    }
    private fun firstTime(): Boolean {
       /* val keySpec = KeyGenParameterSpec.Builder("master_key", KeyProperties.PURPOSE_ENCRYPT or KeyProperties.PURPOSE_DECRYPT)
            .setBlockModes(KeyProperties.BLOCK_MODE_GCM)
            .setEncryptionPaddings(KeyProperties.ENCRYPTION_PADDING_NONE)
            .setKeySize(256)
            .build()
        val masterKey: MasterKey = MasterKey.Builder(this).setKeyGenParameterSpec(keySpec).build()*/
        val shared: SharedPreferences = getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
        var ret = false
        if(shared.getBoolean("first_time", true))
        {
            ret = true
        }
        return ret
    }


}