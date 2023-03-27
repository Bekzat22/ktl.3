package com.example.myapplication.repositiories

import com.example.myapplication.data.Catmodel
import com.example.myapplication.data.Dogmodel

private val BaseUrl:String="https://http.dog/"
class Dogrepository {
    private val ListDog = mutableListOf<Dogmodel>()
    fun Getlistofdog(): MutableList<Dogmodel> {
        ListDog.add(Dogmodel("${BaseUrl}100.jpg", "Continue", "Continue"))
        ListDog.add(Dogmodel("${BaseUrl}101.jpg", "Switching Protocols", "Switching Protocols"))
        ListDog.add(Dogmodel("${BaseUrl}102.jpg", "Processing", "Processing"))
        ListDog.add(Dogmodel("${BaseUrl}103.jpg", "EARLY HINTS", "EARLY HINTS"))
        ListDog.add(Dogmodel("${BaseUrl}200.jpg", "OK", "OK"))
        return ListDog


    }
}