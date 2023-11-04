package com.example.devfestdemo.contruction

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.springframework.stereotype.Service

@Service
class ConstructionService @Autowired constructor(
    val constructionRepository: ConstructionRepository
){
    fun transformConstruction(
        id: Int,
        wallLength: Int,
        wallHeight: Int
    ){
        val evaluatedAreaOfWall = wallHeight * wallLength
        val evaluatedTotalNumberOfWood = evaluatedAreaOfWall * 2
        val evaluatedTotalNumberOfNails= evaluatedAreaOfWall * 8
        val evaluatedTotalPrice = evaluatedAreaOfWall * 100

        val infoToSave = ConstructionInfo(
            id = id,
            wallLength = wallLength,
            wallHeight = wallHeight,
            totalNumberOfWood = evaluatedTotalNumberOfWood,
            totalNumberOfNails = evaluatedTotalNumberOfNails,
            totalPrice = evaluatedTotalPrice
        )

        constructionRepository.saveConstructionDetails(infoToSave)
    }

    fun getRequestedInfo(id: Int): List<ConstructionInfo>?{
        return constructionRepository.getConstructionInfo(id)
    }
}