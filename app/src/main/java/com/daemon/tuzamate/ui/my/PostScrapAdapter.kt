package com.daemon.tuzamate.ui.my

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.daemon.tuzamate.databinding.ItemPostMyBinding

class PostScrapAdapter(
    private val items: List<PostScrap>
) : RecyclerView.Adapter<PostScrapAdapter.PostScrapViewHolder>() {

    inner class PostScrapViewHolder(private val binding: ItemPostMyBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: PostScrap) {
            binding.tvPostHot1Title.text = item.title
            binding.tvPostHot1Date.text = item.date
            binding.tvPostHot1Body.text = item.body
            binding.tvPostHot1CountHeart.text = item.heartCount.toString()
            binding.tvPostHot1CountBookmark.text = item.bookmarkCount.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostScrapViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemPostMyBinding.inflate(inflater, parent, false)
        return PostScrapViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PostScrapViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size
}
