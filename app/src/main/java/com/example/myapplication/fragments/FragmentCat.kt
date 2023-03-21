package com.example.myapplication.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.adapters.AdapterCat
import com.example.myapplication.data.Catmodel
import com.example.myapplication.interfaces.CatClick
import com.example.myapplication.repositiories.CatRepository

class FragmentCat : Fragment(),CatClick {


    private var recycler : RecyclerView?= null
    private var repository =CatRepository()
    private var catAdapter = AdapterCat(repository.Getlistof(),this)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cat, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recycler=view.findViewById(R.id.RecyclerviewCat)
        recycler?.layoutManager = GridLayoutManager(context,2)
        recycler?.adapter = catAdapter


    }

    override fun onItemClick(catmodel: Catmodel) {
        val detailFragment = FragmentdetailItemCat()
        val bundle = Bundle().apply {
            putString("detail", catmodel.detail)
            putString("image", catmodel.image)
        }
        detailFragment.arguments = bundle
        val fragmentManager = requireActivity().supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.Fragment_container, detailFragment)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }


}