package com.example.myapplication

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import java.io.FileOutputStream

class DatabaseHelper(private val context : Context) {

    private val dbName = "mydatabase.db"

    fun copyDatabase() {
        val dbfile = context.getDatabasePath(dbName)

        if (!dbfile.exists()){
            dbfile.parentFile?.mkdirs()
            val input = context.assets.open(dbName)
            val output = FileOutputStream(dbfile)
            input.copyTo(output)
            input.close()
            output.close()
        }


    }

    fun openDatabase() : SQLiteDatabase{
    return context.openOrCreateDatabase(dbName, Context.MODE_PRIVATE,null)
    }
}