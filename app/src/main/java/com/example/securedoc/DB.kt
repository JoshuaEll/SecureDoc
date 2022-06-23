package com.example.securedoc

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DB(context: Context) : SQLiteOpenHelper(context, "STORAGE", null, 1) {
    override fun onCreate(db: SQLiteDatabase?) {
        if (db != null) {
            db.execSQL("CREATE TABLE FILES (file_id INTEGER PRIMARY KEY AUTOINCREMENT, file_name TEXT, )")
        }
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }
}