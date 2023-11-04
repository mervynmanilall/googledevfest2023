package com.example.devfestdemo.contruction

import org.springframework.stereotype.Component

@Component
class ConstructionRepository {

    private var constructionDB: MutableList<ConstructionInfo> = mutableListOf()

    fun saveConstructionDetails(info: ConstructionInfo){
        constructionDB.add(info)
    }

    fun getConstructionInfo(constructionId: Int): List<ConstructionInfo>?{
        return constructionDB.filter { it.id == constructionId }.map {
            it
        }
    }
}