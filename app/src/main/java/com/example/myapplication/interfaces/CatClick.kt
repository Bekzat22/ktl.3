package com.example.myapplication.interfaces

import com.example.myapplication.data.Catmodel
import com.example.myapplication.data.Dogmodel
import com.example.myapplication.data.MoviewModel

interface CatClick {
    fun onItemClick(catmodel:Catmodel)
    fun onItemClickdog(dogmodel: Dogmodel)
    fun onItemClickmovie(moviewModel: MoviewModel)

}