package com.example.myapplication.adapters

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication.data.Catmodel
import com.example.myapplication.databinding.ItemcatBinding
import com.example.myapplication.fragments.FragmentdetailItemCat
import com.example.myapplication.interfaces.CatClick

class AdapterCat(
    private val listmodel: MutableList<Catmodel>,
    private val listener: CatClick
) : RecyclerView.Adapter<AdapterCat.CatViewHolder>() {

    inner class CatViewHolder(private val binding: ItemcatBinding) : RecyclerView.ViewHolder(binding.root) {

        fun onBind(catmodel: Catmodel) {
            binding.apply {
                Glide.with(imageCat).load(catmodel.image).into(imageCat)
                name.text = catmodel.name
                name.text = catmodel.detail
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatViewHolder {
        val binding = ItemcatBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CatViewHolder(binding).apply {
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
