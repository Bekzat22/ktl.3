package com.example.myapplication.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.myapplication.R

class MoviedetailFragment : Fragment() {

    private var detail: TextView? =null
    private var imageView: ImageView? =null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_moviedetail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        detail = view.findViewById(R.id.detail2)
        imageView = view.findViewById(R.id.image_cat1)
        arguments?.let { bundle ->
            val description = bundle.getString("detail")
            val image = bundle.getString("image")
            detail?.text = description
            Glide.with(this).load(image).into(imageView!!)
        }
    }


}