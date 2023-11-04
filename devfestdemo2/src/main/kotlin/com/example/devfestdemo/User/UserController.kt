package com.example.devfestdemo.User

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@CrossOrigin(origins = ["*"])
@RequestMapping("/v1/user")
@Component
class UserController @Autowired constructor(
    val userService: UserService
){
    @PostMapping("/save")
    fun saveUserInformation(
        @RequestParam userId: String,
        @RequestParam firstName: String,
        @RequestParam lastName: String
    ): ResponseEntity<*>{
        return try {
            userService.saveUser(userId, firstName, lastName)
            ResponseEntity.ok("saved")
        } catch (e: Exception) {
            ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Please verify again")
        }
    }

    @GetMapping("/getinfo/{userId}")
    fun getUserInfo(
        @PathVariable userId: String
    ): ResponseEntity<*>{
        return try {
            val retriedUseInfo = userService.getUser(userId)
            ResponseEntity.ok(retriedUseInfo)
        } catch (e: Exception) {
            ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Please verify again")
        }
    }
}