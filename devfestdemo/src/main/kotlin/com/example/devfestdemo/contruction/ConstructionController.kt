package com.example.devfestdemo.contruction

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@CrossOrigin(origins = ["*"])
@RequestMapping("/v1/construction")
@Component

class ConstructionController @Autowired constructor(
    val constructionService: ConstructionService
){
    @PostMapping("/save")
    fun recordConstructionInfo(
        @RequestParam id: Int, @RequestParam wallLength: Int, @RequestParam wallHeight: Int
    ): ResponseEntity<*>{
        return try {
            constructionService.transformConstruction(id, wallLength, wallHeight)
            ResponseEntity.ok("saved")
        } catch (e: Exception) {
            ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Please verify again")
        }
    }

    @GetMapping("/retrieve/{id}")
    fun getConstructionInfo(
        @PathVariable id: Int
    ): ResponseEntity<*>{
        return try {
            val yourInfo = constructionService.getRequestedInfo(id)
            ResponseEntity.ok(yourInfo)
        } catch (e: Exception) {
            ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Please verify again")
        }
    }
}