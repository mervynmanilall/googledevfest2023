package com.example.devfestdemo.User

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserService @Autowired constructor(
    val userRepository: UserRepository
){
    fun saveUser(userId: String, firstName: String, lastName: String){
        val userDetail: UserInfo = UserInfo(
            id = userId,
            name = firstName,
            surname = lastName
        )
        userRepository.saveUserDetail(userDetail)
    }

    fun getUser(userId: String): List<UserInfo>?{
        return userRepository.getUserDetail(userId)
    }
}