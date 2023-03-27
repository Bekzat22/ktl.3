package com.example.myapplication.repositiories

import com.example.myapplication.data.Dogmodel
import com.example.myapplication.data.MoviewModel

private val BaseUrl:String="https://http.garden/"

class Movierepos {
    private val Listmovie = mutableListOf<MoviewModel>()
    fun Getlistofmovie(): MutableList<MoviewModel> {
        Listmovie.add(MoviewModel("${BaseUrl}100.jpg", "continue", "Continue"))
        Listmovie.add(MoviewModel("${BaseUrl}101.jpg", "Switching Protocols", "Switching Protocols"))
        Listmovie.add(MoviewModel("${BaseUrl}102.jpg", "Processing", "Processing"))
        Listmovie.add(MoviewModel("${BaseUrl}103.jpg", "EARLY HINTS", "EARLY HINTS"))
        Listmovie.add(MoviewModel("${BaseUrl}200.jpg", "OK", "OK"))
        return Listmovie


    }
}