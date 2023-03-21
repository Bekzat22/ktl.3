package com.example.myapplication.repositiories

import com.example.myapplication.data.Catmodel
private val BaseUrl:String="https://httpcats.com/"
class CatRepository {
    private val Liscat = mutableListOf<Catmodel>()
    fun Getlistof() : MutableList<Catmodel> {
        Liscat.add(Catmodel("${BaseUrl}100.jpg","Continue","Continue"))
        Liscat.add(Catmodel("${BaseUrl}101.jpg","Switching Protocols","Switching Protocols"))
        Liscat.add(Catmodel("${BaseUrl}102.jpg","Processing","Processing"))
        Liscat.add(Catmodel("${BaseUrl}103.jpg","EARLY HINTS","EARLY HINTS"))
        Liscat.add(Catmodel("${BaseUrl}200.jpg","OK","OK"))
        return Liscat


    }
}