package com.example.securedoc

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class Save  : AppCompatActivity() {
    val startForResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {result: ActivityResult ->
        if (result.resultCode == Activity.RESULT_OK){
            var image: ImageView = findViewById(R.id.imageView2)
            val  data: Intent? = result.data
            val uri: Uri? = data?.data
            var bitmp : Bitmap = MediaStore.Images.Media.getBitmap(this.contentResolver, uri)
            image.setImageBitmap(bitmp)

        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.save)
        var save : Button = findViewById(R.id.button3)
        save.setOnClickListener {
            openFileBrowser(this@Save)
        }
    }

    public fun openFileBrowser(view: Save)
    {
        var data : Intent = Intent(Intent.ACTION_GET_CONTENT)
        data.type = "*/*"
        data = Intent.createChooser(data, "Choose a File")
        startForResult.launch(data)
    }
}