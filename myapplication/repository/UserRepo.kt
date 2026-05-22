package com.example.myapplication.repository

import com.example.myapplication.data.DBHelper
import com.example.myapplication.data.UserModel

class UserRepo(private val dbHelper : DBHelper) {
    fun insert(user : UserModel): Boolean{
        return dbHelper.insertUser(user)
    }

    fun getUsers() : ArrayList<UserModel>{
      return  dbHelper.getAllUsers()
    }
}