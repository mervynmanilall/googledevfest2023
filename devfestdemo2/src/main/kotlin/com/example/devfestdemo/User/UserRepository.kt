package com.example.devfestdemo.User

import org.springframework.stereotype.Component

@Component
class UserRepository {
    val userDB: MutableList<UserInfo> = mutableListOf()

    fun saveUserDetail(newUserInfo: UserInfo){
        userDB.add(newUserInfo)
    }

    fun getUserDetail(userId: String): List<UserInfo>?{
        return userDB.filter { it.id == userId }.map {
            it
        }
    }
}