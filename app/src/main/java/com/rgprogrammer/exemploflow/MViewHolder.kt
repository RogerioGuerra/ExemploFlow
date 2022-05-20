package com.rgprogrammer.exemploflow

import androidx.recyclerview.widget.RecyclerView
import com.rgprogrammer.exemploflow.databinding.ItemMusicBinding

class MViewHolder(private val binding: ItemMusicBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(styleMusic: String) {
        binding.textMusic.text = styleMusic
    }
}
