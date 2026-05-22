package com.example.myapplication.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.myapplication.data.DBHelper
import com.example.myapplication.data.UserModel
import com.example.myapplication.repository.UserRepo

class userViewModel(application : Application) : AndroidViewModel(application) {
    private val repository: UserRepo
    init {
        repository = UserRepo(DBHelper(application))
    }

    fun insertUser(user: UserModel): Boolean {
        return repository.insert(user)
    }

    fun getUsers(): ArrayList<UserModel> {
        return repository.getUsers()
    }
}