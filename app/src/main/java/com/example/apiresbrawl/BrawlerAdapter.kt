package com.example.apiresbrawl

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.brawlstars.R
import com.example.brawlstars.model.Brawler
import kotlinx.android.synthetic.main.item_brawler.view.*

class BrawlerAdapter(private val brawlers: List<Brawler>) :
    RecyclerView.Adapter<BrawlerAdapter.BrawlerViewHolder>() {

    class BrawlerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BrawlerViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_brawler, parent, false)
        return BrawlerViewHolder(view)
    }

    override fun getItemCount() = brawlers.size

    override fun onBindViewHolder(holder: BrawlerViewHolder, position: Int) {
        val brawler = brawlers[position]
        holder.itemView.apply {
            nameTextView.text = brawler.name
            rarityTextView.text = brawler.rarity
            powerTextView.text = brawler.power.toString()
            healthTextView.text = brawler.health.toString()
            speedTextView.text = brawler.speed.toString()

            Glide.with(this)
                .load(brawler.imageUrl)
                .into(imageView)
        }
    }
}
