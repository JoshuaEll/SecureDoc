package com.example.securedoc

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {
    companion object {
        private const val STORAGE_REQUEST_CODE = 101
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.menu)
        val viewDoc: Button = findViewById(R.id.viewButton)
        val saveDoc: Button = findViewById(R.id.saveButton)
        var saveString = ""
        viewDoc.setOnClickListener {
            val intent = Intent(this, View::class.java).apply {

            }
            startActivity(intent)
        }
        saveDoc.setOnClickListener {
            checkPermission(Manifest.permission.READ_EXTERNAL_STORAGE, STORAGE_REQUEST_CODE)
            var intent : Intent = Intent(this, Save::class.java).apply {

            }
            startActivity(intent)

        }

    }

    private fun checkPermission(permission: String, requestCode: Int) {
            if (ContextCompat.checkSelfPermission(
                    this@MainActivity,
                    permission
                ) == PackageManager.PERMISSION_DENIED
            ) {
                // Requesting the permission
                ActivityCompat.requestPermissions(
                    this@MainActivity,
                    arrayOf(permission),
                    requestCode
                )
            } else {
                Toast.makeText(this@MainActivity, "Permission already granted", Toast.LENGTH_SHORT)
                    .show()
            }
        }

        override fun onRequestPermissionsResult(
            requestCode: Int,
            permissions: Array<out String>,
            grantResults: IntArray
        ) {
            super.onRequestPermissionsResult(requestCode, permissions, grantResults)
            if (requestCode == STORAGE_REQUEST_CODE) {
                if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(
                        this@MainActivity,
                        "Storage Permission granted.",
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    Toast.makeText(
                        this@MainActivity,
                        "Storage Permission denied.",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }















