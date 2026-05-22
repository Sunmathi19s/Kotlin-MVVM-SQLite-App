package com.example.myapplication.data

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper (context : Context)  : SQLiteOpenHelper(context,"UserDB",null,1){
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("CREATE TABLE users(id INTEGER PRIMARY KEY AUTOINCREMENT,name TEXT,department TEXT,gender TEXT,terms TEXT)")
    }

    override fun onUpgrade(
        db: SQLiteDatabase?,
        oldVersion: Int,
        newVersion: Int
    ) {
       db?.execSQL("DROP TABLE IF EXISTS users")
        onCreate(db)
    }

    fun insertUser(user : UserModel) : Boolean{
        val db = writableDatabase
        val values = ContentValues()
        values.put("name", user.name)
        values.put("department", user.department)
        values.put("gender", user.gender)
        values.put("terms", user.terms)

        val result = db.insert("users", null, values)

        return result != -1L
    }

    fun getAllUsers() : ArrayList<UserModel>{
        val list = ArrayList<UserModel>()

        val db = readableDatabase

        val cursor = db.rawQuery("SELECT * FROM users", null)
        while (cursor.moveToNext()) {

            list.add(
                UserModel(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getString(4),
                )
            )
        }

        cursor.close()

        return list
    }
}