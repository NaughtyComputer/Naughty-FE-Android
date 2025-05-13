package com.daemon.tuzamate.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.daemon.tuzamate.databinding.ItemCardBinding

class CardNewsAdapter(
    private val cardList: List<Card>
) : RecyclerView.Adapter<CardNewsAdapter.CardViewHolder>() {

    inner class CardViewHolder(private val binding: ItemCardBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(card: Card) {
            binding.card = card
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val binding = ItemCardBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return CardViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        holder.bind(cardList[position])
    }

    override fun getItemCount(): Int = cardList.size
}