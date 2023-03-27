package com.example.myapplication.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication.R
import com.example.myapplication.data.Dogmodel
import com.example.myapplication.databinding.ItemdogBinding
import com.example.myapplication.interfaces.CatClick

class AdapterDog(
    private val listmodeldog: MutableList<Dogmodel>,
    private val listener: CatClick
) : RecyclerView.Adapter<AdapterDog.DogViewHolder>() {

    inner class DogViewHolder(private val binding: ItemdogBinding) : RecyclerView.ViewHolder(binding.root) {

        fun onBind(dogModel: Dogmodel) {
            binding.imageCat.let { Glide.with(it).load(dogModel.image).into(binding.imageCat) }
            binding.name.text = dogModel.name
            binding.name.text = dogModel.detail
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogViewHolder {
        val binding = ItemdogBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DogViewHolder(binding).apply {
            binding.root.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    listener.onItemClickdog(listmodeldog[position])
                }
            }
        }
    }

    override fun getItemCount(): Int = listmodeldog.size

    override fun onBindViewHolder(holder: DogViewHolder, position: Int) {
        holder.onBind(listmodeldog[position])
    }

}
