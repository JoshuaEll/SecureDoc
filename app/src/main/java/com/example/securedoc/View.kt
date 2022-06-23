package com.example.securedoc

import android.content.pm.PackageManager
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import androidx.activity.result.ActivityResultLauncher
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import java.util.jar.Manifest

class View : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.view)
       // val data : SQLiteDatabase = openOrCreateDatabase("Storage", MODE_PRIVATE, null)

    }


}