package com.example.myapplication.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication.data.MoviewModel
import com.example.myapplication.databinding.ItemmovieBinding
import com.example.myapplication.interfaces.CatClick

class AdapterMoview(
    private val listmodelmovie: MutableList<MoviewModel>,
    private val listener: CatClick
) : RecyclerView.Adapter<AdapterMoview.MoviewViewHolder>() {

    inner class MoviewViewHolder(private val binding: ItemmovieBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(moviewModel: MoviewModel) {
            Glide.with(binding.root.context).load(moviewModel.image).into(binding.imageCat)
            binding.name.text = moviewModel.name
            binding.name.text = moviewModel.detail
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviewViewHolder {
        val binding = ItemmovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MoviewViewHolder(binding).apply {
            itemView.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    listener.onItemClickmovie(listmodelmovie[position])
                }
            }
        }
    }

    override fun getItemCount(): Int = listmodelmovie.size

    override fun onBindViewHolder(holder: MoviewViewHolder, position: Int) {
        holder.onBind(listmodelmovie[position])
    }
}
