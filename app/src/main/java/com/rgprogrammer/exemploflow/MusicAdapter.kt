package com.rgprogrammer.exemploflow

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rgprogrammer.exemploflow.databinding.ItemMusicBinding

class MusicAdapter : RecyclerView.Adapter<MViewHolder>() {
    private val styles: MutableList<String> = mutableListOf()
    fun addMusic(music: String) {
        styles.add(music)
        notifyItemInserted(itemCount)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MViewHolder {
        val binding = ItemMusicBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MViewHolder, position: Int) {
        holder.bind(styles[position])
    }

    override fun getItemCount(): Int {
        return styles.size
    }
}
