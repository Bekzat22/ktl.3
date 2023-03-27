package com.example.myapplication.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.example.myapplication.R
import com.example.myapplication.adapters.AdapterDog
import com.example.myapplication.adapters.AdapterMoview
import com.example.myapplication.data.Catmodel
import com.example.myapplication.data.Dogmodel
import com.example.myapplication.data.MoviewModel
import com.example.myapplication.databinding.FragmentDogBinding
import com.example.myapplication.databinding.FragmentMovieBinding
import com.example.myapplication.interfaces.CatClick
import com.example.myapplication.repositiories.Dogrepository
import com.example.myapplication.repositiories.Movierepos


class MovieFragment : Fragment(), CatClick {
    private lateinit var  binding: FragmentMovieBinding
    private var repository = Movierepos()
    private var catAdapter = AdapterMoview(repository.Getlistofmovie(),this)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMovieBinding.inflate(inflater,container,false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.RecyclerviewMovie
        binding.RecyclerviewMovie.layoutManager = GridLayoutManager(context,2)
        binding.RecyclerviewMovie.adapter = catAdapter
    }

    override fun onItemClick(catmodel: Catmodel) {

    }

    override fun onItemClickdog(dogmodel: Dogmodel) {

    }

    override fun onItemClickmovie(moviewModel: MoviewModel) {
        val detailFragment = MoviedetailFragment()
        val bundle = Bundle().apply {
            putString("detail", moviewModel.detail)
            putString("image", moviewModel.image)
        }
        detailFragment.arguments = bundle
        val fragmentManager = requireActivity().supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.Fragment_container, detailFragment)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }


}
