package com.example.myapplication.adapters

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication.R
import com.example.myapplication.data.Catmodel
import com.example.myapplication.fragments.FragmentdetailItemCat
import com.example.myapplication.interfaces.CatClick

class AdapterCat(
    private val listmodel: MutableList<Catmodel>,
    private val listener: CatClick
) : RecyclerView.Adapter<AdapterCat.CatViewHolder>() {

    class CatViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private var image: ImageView? = null
        private var name: TextView? = null
        private var detail: TextView? = null

        init {
            image = view.findViewById(R.id.image_cat)
            name = view.findViewById(R.id.name)
            detail = view.findViewById(R.id.detail2)
        }

        fun onBind(catmodel: Catmodel) {
            image?.let { Glide.with(it).load(catmodel.image).into(image!!) }
            name?.text = catmodel.name
            detail?.text = catmodel.detail
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatViewHolder {
        return CatViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.itemcat, parent, false)
        ).apply {
            itemView.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    listener.onItemClick(listmodel[position])
                }
            }
        }
    }

    override fun getItemCount(): Int = listmodel.size

    override fun onBindViewHolder(holder: CatViewHolder, position: Int) {
        holder.onBind(listmodel[position])
    }

}
